package com.example.lifepartneroservice.model.record;

import com.example.lifepartneroservice.entity.record.RecordType;

public record RecordDto(long id, String name, RecordType recordType) {
}
