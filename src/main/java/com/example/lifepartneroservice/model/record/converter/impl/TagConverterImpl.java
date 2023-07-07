package com.example.lifepartneroservice.model.record.converter.impl;

import com.example.lifepartneroservice.entity.record.Tag;
import com.example.lifepartneroservice.model.record.TagDto;
import com.example.lifepartneroservice.model.record.converter.TagConverter;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TagConverterImpl implements TagConverter {

    @Override
    public Tag toEntity(TagDto dto) {
        return Tag.builder()
                .id(dto.id())
                .name(dto.name())
                .build();
    }

    @Override
    public TagDto toDto(Tag entity) {
        return new TagDto(
                entity.getId(),
                entity.getName()
        );
    }

    @Override
    public Set<TagDto> toSetDto(Set<Tag> tags) {
        return tags.stream()
                .map(it -> new TagDto(it.getId(), it.getName()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Tag> toSetEntity(Set<TagDto> tagsDto) {
        return tagsDto.stream()
                .map(it -> Tag.builder()
                        .id(it.id())
                        .name(it.name())
                        .build())
                .collect(Collectors.toSet());
    }
}
