package com.example.lifepartneroservice.entity.record.projection;

import com.example.lifepartneroservice.entity.projection.BaseProjection;
import com.example.lifepartneroservice.entity.record.Record;
import com.example.lifepartneroservice.entity.record.RecordType;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(
        name = "recordBaseProjection",
        types = {Record.class}
)
public interface RecordBaseProjection extends BaseProjection {

    String getName();

    RecordType getRecordType();

    Set<TagBaseProjection> getTags();
}
