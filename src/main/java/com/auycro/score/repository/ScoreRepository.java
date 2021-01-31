package com.auycro.score.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.auycro.score.entity.ScoreEntity;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {
  @Query(value = "SELECT * FROM scores s Where s.time <= :before AND s.time >= :after",nativeQuery = true)
  Page<ScoreEntity> findByTimerange(@Param("before") long before, @Param("after") long after, Pageable pageable);

  @Query(value = "SELECT * FROM scores s Where s.player in :players AND (s.time <= :before AND s.time >= :after)", nativeQuery = true)
  Page<ScoreEntity> findByPlayerAndTimerange(@Param("players") List<String> players, @Param("before") long before, @Param("after") long after, Pageable pageable);
}
