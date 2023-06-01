package com.example.lifepartneroservice.entity.converter;

import com.example.lifepartneroservice.entity.record.RecordType;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RecordTypeConverter extends EnumAttributeConverter<RecordType> {
    public RecordTypeConverter(Class<RecordType> clazz) {
        super(clazz);
    }
}
