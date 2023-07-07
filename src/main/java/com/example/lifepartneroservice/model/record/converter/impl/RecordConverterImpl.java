package com.example.lifepartneroservice.model.record.converter.impl;

import com.example.lifepartneroservice.entity.record.Record;
import com.example.lifepartneroservice.entity.record.Tag;
import com.example.lifepartneroservice.model.record.RecordDto;
import com.example.lifepartneroservice.model.record.converter.RecordConverter;
import com.example.lifepartneroservice.model.record.converter.TagConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecordConverterImpl implements RecordConverter {

    private final TagConverter tagConverter;

    @Override
    public Record toEntity(RecordDto dto) {
        return convertToEntity(dto.id(), dto);
    }

    @Override
    public Record toEntity(long id, RecordDto dto) {
        return convertToEntity(id, dto);
    }

    @Override
    public RecordDto toDto(Record entity) {
        return new RecordDto(
                entity.getId(),
                entity.getName(),
                entity.getRecordType(),
                entity.getText(),
                tagConverter.toSetDto(entity.getTags())
        );
    }

    private Record convertToEntity(long id, RecordDto dto) {
        return Record.builder()
                .id(id)
                .name(dto.name())
                .recordType(dto.recordType())
                .text(dto.text())
                .tags(tagConverter.toSetEntity(dto.tags()))
                .build();
    }
}
