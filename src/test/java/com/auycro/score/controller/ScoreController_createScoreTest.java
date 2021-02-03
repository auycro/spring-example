package com.auycro.score.controller;

//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
//import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
//@EnableWebMvc
public class ScoreController_createScoreTest {
  // @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ScoreController scoreController;

  @BeforeEach
  public void setup(){
    mockMvc = MockMvcBuilders.standaloneSetup(scoreController).build();
  }

  @Test
  public void shouldBeOK_DateOnly() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/scores")
      .contentType("application/json")
      .param("player", "foobar")
      .param("score", "100")
      .param("time", "2021-01-25")
    ).andExpect(status().isOk());
  }

  @Test
  public void shouldBeOK_DateTime() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/scores")
      .contentType("application/json")
      .param("player", "foobar")
      .param("score", "100")
      .param("time", "2021-01-25 10:00:00")
    ).andExpect(status().isOk());
  }

  @Test
  public void shouldBeBadRequest_NoParam() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/scores")
      .contentType("application/json")
    ).andExpect(status().isBadRequest());
  }

  //TODO: add validation class to createScore
  /***
  @Test
  public void shouldBeBadRequest_ParameterError() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/scores")
      .contentType("application/json")
      .param("player", "foobar")
      .param("score", "BBBB")
      .param("time", "AAAA")
    ).andDo(print());
  }
  ***/

}
