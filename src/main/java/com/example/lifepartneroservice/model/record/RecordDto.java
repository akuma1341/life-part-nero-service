package com.example.lifepartneroservice.model.record;

import com.example.lifepartneroservice.entity.record.RecordType;

import java.util.Set;

public record RecordDto(
        long id,
        String name,
        RecordType recordType,
        String text,
        Set<TagDto> tags
) {
}
