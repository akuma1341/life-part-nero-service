package com.example.lifepartneroservice.entity.record.projection;

import com.example.lifepartneroservice.entity.record.Link;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(
        name = "linkChildrenOneDepthBaseProjection",
        types = {Link.class}
)
public interface LinkChildrenOneDepthProjection extends LinkBaseProjection {

    Set<LinkBaseProjection> getChildren();

}
