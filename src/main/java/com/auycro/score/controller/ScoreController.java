package com.auycro.score.controller;
//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auycro.score.model.*;

@RestController
public class ScoreController {

	//private static final String template = "Hello, %s!";
	//private final AtomicLong counter = new AtomicLong();

  //Get Score
  //GET /scores/{id}
	@GetMapping("/score")
	public Score getScore(@RequestParam(value = "id", defaultValue = "0") long id) {
    //return new Score(counter.incrementAndGet(), String.format(template, name), 5, 10000000);
    return new Score(id, "player1", 10, 1611759148);
  }
  
  //Delete Score
  //DELETE /scores/{id}

  //Get list of scores
  //GET /scores
  //parameter {player}
  //parameter {time}
  //parameter player=[player1,player2,player3], time={time}
  //patameter start={time1},end{time2}

  //GET /users/{id}/history
}