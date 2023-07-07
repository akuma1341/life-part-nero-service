package com.example.lifepartneroservice.service.record;

import com.example.lifepartneroservice.model.record.RecordDto;

import java.util.Set;

public interface RecordService {

    RecordDto create(RecordDto recordDto);

    void associateWithRecords(Long recordId, Set<Long> otherRecordIds);
}
