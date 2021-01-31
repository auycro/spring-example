package com.auycro.score.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.auycro.score.entity.ScoreEntity;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {

  @Query(value = "SELECT * FROM scores s Where s.player in :players",nativeQuery = true)
  Iterable<ScoreEntity> findByPlayers(@Param("players") List<String> players);
}
