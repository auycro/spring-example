package com.auycro.score.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.auycro.score.model.Score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

public class ScoreController_createScoreTest {
  
  private String player;
  private int score;
  private String time;

  //@Autowired
  //private MockMvc mockMvc;

  @MockBean
  private ScoreController scoreController;

  @BeforeEach
  public void initScore(){
    this.player = "foobar";
    this.score = 99999;
    this.time = "2020-02-02";
  }

 //TODO: fix null pointer here 
  @Test
  public void shouldBeOK(){
    //ResponseEntity<Score> s = scoreController.createScore(player,score,time);
    assertEquals(200, scoreController.createScore(player,score,time));
  }

}
