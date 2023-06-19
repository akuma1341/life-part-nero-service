package com.example.lifepartneroservice.service.record.impl;

import com.example.lifepartneroservice.entity.record.RecordType;
import com.example.lifepartneroservice.model.record.RecordDto;
import com.example.lifepartneroservice.model.record.converter.RecordConverter;
import com.example.lifepartneroservice.repository.record.RecordRepository;
import com.example.lifepartneroservice.service.record.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;
    private final RecordConverter recordConverter;

    public List<RecordDto> getAllRecords() {

        return recordRepository.findAll().stream()
                .map(recordConverter::toDto)
                .toList();
    }

    @Override
    public RecordDto create(RecordDto recordDto) {
        var newRecord = recordRepository.save(recordConverter.toEntity(recordDto));
        return recordConverter.toDto(newRecord);
    }
}
