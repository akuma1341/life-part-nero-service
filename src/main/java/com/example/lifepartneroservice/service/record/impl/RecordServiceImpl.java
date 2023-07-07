package com.example.lifepartneroservice.service.record.impl;

import com.example.lifepartneroservice.entity.record.Link;
import com.example.lifepartneroservice.model.record.RecordDto;
import com.example.lifepartneroservice.model.record.converter.RecordConverter;
import com.example.lifepartneroservice.model.record.converter.TagConverter;
import com.example.lifepartneroservice.repository.record.LinkRepository;
import com.example.lifepartneroservice.repository.record.RecordRepository;
import com.example.lifepartneroservice.service.record.RecordService;
import com.example.lifepartneroservice.service.record.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;
    private final LinkRepository linkRepository;
    private final TagService tagService;
    private final TagConverter tagConverter;
    private final RecordConverter recordConverter;

    @Override
    @Transactional
    public RecordDto create(RecordDto recordDto) {
        var existingTags = recordDto.tags().stream()
                .map(it -> tagConverter.toDto(tagService.createIfNotExist(it.name())))
                .collect(Collectors.toSet());

        recordDto.tags().clear();
        recordDto.tags().addAll(existingTags);

        var createdRecord = recordRepository.save(recordConverter.toEntity(recordDto));

        var newLink = Link.builder()
                .record(createdRecord)
                .build();
        linkRepository.save(newLink);

        return recordConverter.toDto(createdRecord);
    }

    @Override
    @Transactional
    public void associateWithRecords(Long recordId, Set<Long> otherRecordIds) {
        var link = linkRepository.findById(recordId).orElseThrow(
                () -> new IllegalArgumentException(String.format("Record with id %s not found.", recordId))
        );

        var childrenLinks = linkRepository.findAllUniqByIds(otherRecordIds);
        link.setChildren(childrenLinks);
        linkRepository.save(link);
    }
}
