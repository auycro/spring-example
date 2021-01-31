package com.auycro.score.repository;

import org.springframework.data.repository.CrudRepository;

import com.auycro.score.entity.ScoreEntity;

public interface ScoreRepository extends CrudRepository<ScoreEntity, Long> {
  
}
