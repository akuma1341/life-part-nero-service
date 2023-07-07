package com.example.lifepartneroservice.controller;

import com.example.lifepartneroservice.model.record.RecordDto;
import com.example.lifepartneroservice.service.record.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@BasePathAwareController
@RestController
@RequiredArgsConstructor
public class RecordsController {

    private final RecordService recordService;

    @PostMapping("records/createRecord")
    public RecordDto create(@RequestBody RecordDto recordDto) {
        return recordService.create(recordDto);
    }

    @PostMapping("records/{id}/associateWithRecords")
    public void associateWithRecords(@PathVariable("id") long recordId, @RequestBody Set<Long> otherRecordIds) {
        recordService.associateWithRecords(recordId, otherRecordIds);
    }
}
