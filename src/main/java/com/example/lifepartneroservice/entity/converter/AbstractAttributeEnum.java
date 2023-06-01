package com.example.lifepartneroservice.entity.converter;

import java.util.Arrays;
import java.util.Objects;

public interface AbstractAttributeEnum {

    int getCode();

    static <E extends AbstractAttributeEnum> E valueOf(Class<E> clazz, int code) {
        return Arrays.stream(clazz.getEnumConstants())
                .filter(it -> it.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(
                        "Constant in %s with %s doesn't exist",
                        clazz.getSimpleName(), code)));
    }
}
