package com.example.lifepartneroservice.entity.record;

import com.example.lifepartneroservice.entity.AbstractAttributeEnum;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum RecordType implements AbstractAttributeEnum {

    REVIEW(1),
    NOTICE(2),
    QUOTE(3),
    THOUGHT(4);

    private final int code;

    @Override
    public Integer getCode() {
        return code;
    }
}
