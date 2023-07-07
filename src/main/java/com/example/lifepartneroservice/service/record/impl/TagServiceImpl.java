package com.example.lifepartneroservice.service.record.impl;

import com.example.lifepartneroservice.entity.record.Tag;
import com.example.lifepartneroservice.repository.record.TagRepository;
import com.example.lifepartneroservice.service.record.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    @Transactional
    public Tag createIfNotExist(String tagName) {
        var tag = tagRepository.findByName(tagName);
        return tag.orElseGet(
                () -> tagRepository.save(Tag.builder()
                        .name(tagName)
                        .build()
                )
        );
    }
}
