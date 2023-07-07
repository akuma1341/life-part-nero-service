package com.example.lifepartneroservice.model.record.converter;

import com.example.lifepartneroservice.entity.record.Tag;
import com.example.lifepartneroservice.model.record.TagDto;

import java.util.Set;

public interface TagConverter {

    Tag toEntity(TagDto dto);

    TagDto toDto(Tag entity);

    Set<TagDto> toSetDto(Set<Tag> tags);

    Set<Tag> toSetEntity(Set<TagDto> tagsDto);

}
