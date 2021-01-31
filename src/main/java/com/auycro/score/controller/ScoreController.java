package com.auycro.score.controller;
//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.StackWalker.Option;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

  @GetMapping("/")
  String hello() {
      return "Hello Spring Boot!";
  }

  //Get Score
  //GET /scores/{id}
	@GetMapping("/scores")
	public Score getScore(@RequestParam(value = "id", defaultValue = "0") long id) {
    List<Score> result = new ArrayList<Score>();
    try {
      Iterator<ScoreEntity> score_iterator = scoreRepository.findAll().iterator();
      while(score_iterator.hasNext()){
        ScoreEntity m = score_iterator.next();
        Score s = new Score(m.getId(),m.getPlayer(),m.getScore(),m.getTime().getTime());
        result.add(s);
      }
    } catch (Exception e){
      System.out.println(e);
    }
    return (result.size() > 0)? result.get(0) : null;
  }

  //Create Score
  //POST /score
  @PostMapping("/scores")
  public @ResponseBody String createScore (@RequestParam String player, @RequestParam int score,@RequestParam String time) {
    try{
      ScoreEntity s = new ScoreEntity();
      s.setPlayer(player);
      s.setScore(score);
      Date date = new Date();
      s.setTime(new Timestamp(date.getTime()));
      scoreRepository.save(s);
    } catch (Exception e){
      System.out.println(e);
    }
    return "Saved";
  }  

  //Delete Score
  //DELETE /score/{id}
  @DeleteMapping("/scores")
  public @ResponseBody String deleteScore(@RequestParam(value = "id", defaultValue = "0") long id) {
    try{
      Optional<ScoreEntity> s = scoreRepository.findById(id);
      if (s.isPresent()){
        scoreRepository.delete(s.get());
      }
    }catch (Exception e){
      System.out.println(e);
    }
    return "Deleted";
  }

  //Get list of scores
  //GET /scores
  //parameter {player}
  //parameter {time}
  //parameter player=[player1,player2,player3], time={time}
  //patameter start={time1},end{time2}

  //GET /users/{id}/history
}