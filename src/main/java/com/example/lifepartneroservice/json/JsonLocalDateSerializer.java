package com.example.lifepartneroservice.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JsonLocalDateSerializer extends JsonSerializer<LocalDate> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void serialize(LocalDate date, JsonGenerator generator, SerializerProvider provider) throws IOException {
        var dateString = date.format(FORMATTER);
        generator.writeString(dateString);
    }
}
