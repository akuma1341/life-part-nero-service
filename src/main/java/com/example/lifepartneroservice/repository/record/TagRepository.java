package com.example.lifepartneroservice.repository.record;

import com.example.lifepartneroservice.entity.record.Tag;
import com.example.lifepartneroservice.repository.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TagRepository extends BaseRepository<Tag> {
}
