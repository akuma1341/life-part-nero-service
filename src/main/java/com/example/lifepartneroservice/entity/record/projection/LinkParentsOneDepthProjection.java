package com.example.lifepartneroservice.entity.record.projection;

import com.example.lifepartneroservice.entity.record.Link;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(
        name = "linkParentsOneDepthProjection",
        types = {Link.class}
)
public interface LinkParentsOneDepthProjection extends LinkBaseProjection {

    Set<LinkBaseProjection> getParents();

}
