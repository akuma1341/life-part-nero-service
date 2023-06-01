package com.example.lifepartneroservice.entity.converter;

import jakarta.persistence.AttributeConverter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
abstract public class EnumAttributeConverter<E extends AbstractAttributeEnum> implements AttributeConverter<E, Integer> {

    private final Class<E> clazz;

    @Override
    public Integer convertToDatabaseColumn(E attribute) {
        return attribute.getCode();
    }

    @Override
    public E convertToEntityAttribute(Integer code) {
        return AbstractAttributeEnum.valueOf(clazz, code);
    }
}
