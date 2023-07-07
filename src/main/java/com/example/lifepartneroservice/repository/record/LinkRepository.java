package com.example.lifepartneroservice.repository.record;

import com.example.lifepartneroservice.entity.record.Link;
import com.example.lifepartneroservice.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource
public interface LinkRepository extends BaseRepository<Link> {

    @Query("SELECT DISTINCT link FROM Link link WHERE link.id IN (:ids)")
    Set<Link> findAllUniqByIds(@Param("ids") Set<Long> ids);

}
