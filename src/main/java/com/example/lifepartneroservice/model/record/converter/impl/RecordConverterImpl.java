package com.example.lifepartneroservice.model.record.converter.impl;

import com.example.lifepartneroservice.entity.record.Record;
import com.example.lifepartneroservice.model.record.RecordDto;
import com.example.lifepartneroservice.model.record.converter.RecordConverter;
import org.springframework.stereotype.Component;

@Component
public class RecordConverterImpl implements RecordConverter {

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
        return new RecordDto(entity.getId(), entity.getName());
    }

    private Record convertToEntity(long id, RecordDto dto) {
        return Record.builder()
                .id(id)
                .name(dto.name())
                .build();
    }
}
