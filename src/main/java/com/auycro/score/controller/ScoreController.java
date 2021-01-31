package com.auycro.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.auycro.score.model.*;
import com.auycro.score.repository.ScoreRepository;
import com.auycro.score.entity.ScoreEntity;

@RestController
public class ScoreController {
  
  @Autowired
  private ScoreRepository scoreRepository;

  //@GetMapping("/")
  //String hello() {
  //    return "Hello Spring Boot!";
  //}

  //Get Score
  //GET /scores/{id}
	@GetMapping("/scores/{id}")
	public ResponseEntity<Score> getScore(@PathVariable long id) {
    Score result = null;
    try {
      Optional<ScoreEntity> s = scoreRepository.findById(id);
      if (s.isPresent()){
        result = new Score(s.get()); 
        return ResponseEntity.status(HttpStatus.OK).body(result);
      }
    } catch (Exception e){
      System.out.println(e);
    }
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  //Create Score
  //POST /score
  @PostMapping("/scores")
  public ResponseEntity<Score> createScore (
    @RequestParam(value = "player", defaultValue = "")  String player,
    @RequestParam(value = "score", defaultValue = "-1")  int score,
    @RequestParam(value = "time", defaultValue = "")  String time
  ) {
    Score result = null;
    try{
      ScoreEntity s = new ScoreEntity(player,score,time);
      result = new Score(scoreRepository.saveAndFlush(s));
      return ResponseEntity.status(HttpStatus.OK).body(result);
    } catch (Exception e){
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }  

  //Delete Score
  //DELETE /score/{id}
  @DeleteMapping("/scores/{id}")
  public ResponseEntity<Score> deleteScore(@PathVariable long id) {
    Score result = null;
    try{
      Optional<ScoreEntity> s = scoreRepository.findById(id);
      if (s.isPresent()){
        result = new Score(s.get());
        scoreRepository.delete(s.get());
        return ResponseEntity.status(HttpStatus.OK).body(result);
      }
    }catch (Exception e){
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  //Get list of scores
  //GET /scores/search
  //parameter {player}
  //parameter {time}
  //parameter player=[player1,player2,player3], time={time}
  //patameter start={time1},end{time2}
  @GetMapping("/scores/search")
  public ResponseEntity<List<Score>> getScoreBySearch(
    @RequestParam(value = "player", required = false) List<String> player,
    @RequestParam(value = "since", required = false) String since,
    @RequestParam(value = "until", required = false) String until
  ) {
    if (player == null && since == null && until == null){
      //return ResponseEntity.status(HttpStatus.OK).body(getScoreAll());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } else if (player != null && since == null && until == null) {
      return ResponseEntity.status(HttpStatus.OK).body(getScoreByPlayers(player));
    }

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

/*
  private List<Score> getScoreAll() {
    List<Score> result = new ArrayList<Score>();
    Iterator<ScoreEntity> score_iterator = scoreRepository.findAll().iterator();
    while(score_iterator.hasNext()){
      ScoreEntity m = score_iterator.next();
      Score s = new Score(m.getId(),m.getPlayer(),m.getScore(),m.getTime());
      result.add(s);
    }
    return result;
  }
*/

  private List<Score> getScoreByPlayers(List<String> player) {
    List<Score> result = new ArrayList<Score>();
    Iterator<ScoreEntity> score_iterator = scoreRepository.findByPlayers(player).iterator();
    while(score_iterator.hasNext()){
      ScoreEntity m = score_iterator.next();
      Score s = new Score(m.getId(),m.getPlayer(),m.getScore(),m.getTime());
      result.add(s);
    }
    return result;
  }

  //GET /users/{id}/history
}