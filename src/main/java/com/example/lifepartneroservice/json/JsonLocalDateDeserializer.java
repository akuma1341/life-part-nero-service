package com.example.lifepartneroservice.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JsonLocalDateDeserializer extends JsonDeserializer<LocalDate> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext context) throws IOException {
        var oc = p.getCodec();
        TextNode node = oc.readTree(p);
        var dateString = node.textValue();
        return LocalDate.parse(dateString, FORMATTER);
    }
}
