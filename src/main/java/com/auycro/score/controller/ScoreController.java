package com.auycro.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.NotImplemented;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.auycro.score.model.*;
import com.auycro.score.repository.ScoreRepository;
import com.auycro.score.utility.DateUtility;
import com.auycro.score.utility.StringUtility;
import com.auycro.score.entity.ScoreEntity;

@RestController
public class ScoreController {
  
  @Autowired
  private ScoreRepository scoreRepository;

  //Get Score
  //GET /scores/{id}
	@GetMapping("/scores/{id}")
	public ResponseEntity<Score> getScore(@PathVariable(required = true, value = "id") long id) {
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
    @RequestParam(value = "player", required = true)  String player,
    @RequestParam(value = "score", required =  true)  int score,
    @RequestParam(value = "time", required =  true)  String time
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
  public ResponseEntity<Score> deleteScore(@PathVariable(required = true, name = "id") long id) {
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
  //patameter before={time1},after{time2}
  @GetMapping("/scores/search")
  public ResponseEntity<List<Score>> getScoreBySearch(
    @RequestParam(value = "player", required = false) List<String> player,
    @RequestParam(value = "before", required = false) String before_str,
    @RequestParam(value = "after", required = false) String after_str,
    @RequestParam(value = "page", defaultValue = "0", required = false) int page,
    @RequestParam(value = "limit", defaultValue = "5", required = false) int limit
  ) {
    if (before_str == null && after_str == null && player == null){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    try {
      Pageable paging = PageRequest.of(page, limit);

      long before = (before_str != null)? DateUtility.toUnixTimestamp(before_str) : Long.MAX_VALUE;
      long after = (after_str != null)? DateUtility.toUnixTimestamp(after_str) : Long.MIN_VALUE;

      return ResponseEntity.status(HttpStatus.OK).body(getScoreByPlayersAndTimerange(player, before, after, paging));
    } catch (Exception e){
      System.out.println(e);
      ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  private List<Score> getScoreByPlayersAndTimerange(List<String> player, long before, long after, Pageable paging) {
    Page<ScoreEntity> score_page = null;
    if (player == null || player.size() < 1){
      score_page = scoreRepository.findByTimerange(before, after, paging);
    } else {
      score_page = scoreRepository.findByPlayerAndTimerange(player, before, after, paging);
    }
    List<ScoreEntity> score_entities = score_page.getContent();
    return toScoreList(score_entities);
  }

  private List<Score> toScoreList(List<ScoreEntity> score_entities){
    List<Score> result = new ArrayList<Score>();
    for (ScoreEntity s : score_entities) {
      result.add(new Score(s));
    }
    return result;
  }
  
  //GET /history
  //parameter {player}
  @GetMapping("/history")
  public ResponseEntity<History> getHistory(@RequestParam(value = "player", required = true) String player){
    List<Score> scores = new ArrayList<Score>();
    try {
      Iterator<ScoreEntity> score_entities = scoreRepository.findByHashPlayer(StringUtility.toMD5(player)).iterator();
      while(score_entities.hasNext()){
        scores.add(new Score(score_entities.next()));
      }
      if (scores.size() > 0){
        History history = new History(scores);
        return ResponseEntity.status(HttpStatus.OK).body(history); 
      }
    } catch (Exception e){
      System.out.println(e);
      ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  // TODO: Add Time Validate
  private boolean validateTime(String time) throws NotImplementedException {
    throw new NotImplementedException("validateTime");
  }
}