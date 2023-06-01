package com.example.lifepartneroservice.model.record.converter;

import com.example.lifepartneroservice.entity.record.Record;
import com.example.lifepartneroservice.model.record.RecordDto;

public interface RecordConverter {

    Record toEntity(RecordDto dto);

    Record toEntity(long id, RecordDto dto);

    RecordDto toDto(Record entity);
}
