package com.example.lifepartneroservice.entity.record.projection;

import com.example.lifepartneroservice.entity.projection.BaseProjection;
import com.example.lifepartneroservice.entity.record.Link;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(
        name = "linkBaseProjection",
        types = {Link.class}
)
public interface LinkBaseProjection extends BaseProjection {

    @Value("#{target.record.name}")
    String getName();

}
