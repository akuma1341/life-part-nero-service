package com.example.lifepartneroservice.repository.record;

import com.example.lifepartneroservice.entity.record.Record;
import com.example.lifepartneroservice.repository.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RecordRepository extends BaseRepository<Record> {
}
