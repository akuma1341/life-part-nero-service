package com.example.lifepartneroservice.entity;

import com.example.lifepartneroservice.entity.converter.EnumAttributeConverter;
import com.example.lifepartneroservice.entity.record.RecordType;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.Objects;

public interface AbstractAttributeEnum {

    Integer getCode();

    static <E extends AbstractAttributeEnum> E valueOf(Class<E> clazz, Integer code) {
        return Arrays.stream(clazz.getEnumConstants())
                .filter(it -> Objects.equals(it.getCode(), code))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException(String.format(
                        "Constant in %s with %s doesn't exist",
                        clazz.getSimpleName(), code)));
    }
}

@Converter(autoApply = true)
class RecordTypeConverter extends EnumAttributeConverter<RecordType> {
    public RecordTypeConverter() {
        super(RecordType.class);
    }
}
