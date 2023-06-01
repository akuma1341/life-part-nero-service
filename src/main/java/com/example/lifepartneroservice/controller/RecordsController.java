package com.example.lifepartneroservice.controller;

import com.example.lifepartneroservice.model.record.RecordDto;
import com.example.lifepartneroservice.service.record.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@BasePathAwareController
@RestController
@RequiredArgsConstructor
public class RecordsController {

    private final RecordService recordService;

    @GetMapping("/allRecords")
    public List<RecordDto> getAllRecords() {
        return recordService.getAllRecords();
    }
}
