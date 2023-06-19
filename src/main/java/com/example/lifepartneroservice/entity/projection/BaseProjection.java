package com.example.lifepartneroservice.entity.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder("id")
public interface BaseProjection {

    Long getId();
}
