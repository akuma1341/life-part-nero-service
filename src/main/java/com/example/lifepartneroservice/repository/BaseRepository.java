package com.example.lifepartneroservice.repository;

import com.example.lifepartneroservice.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends AbstractEntity> extends JpaRepository<E, Long> {//, JpaSpecificationExecutor<E>, QuerydslPredicateExecutor<E> {
}
