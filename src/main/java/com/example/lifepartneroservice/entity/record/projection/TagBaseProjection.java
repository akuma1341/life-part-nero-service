package com.example.lifepartneroservice.entity.record.projection;

import com.example.lifepartneroservice.entity.projection.BaseProjection;
import com.example.lifepartneroservice.entity.record.Tag;
import org.springframework.data.rest.core.config.Projection;

@Projection(
        name = "tagBaseProjection",
        types = Tag.class
)
public interface TagBaseProjection extends BaseProjection {

    String getName();
}
