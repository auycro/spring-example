package com.auycro.score.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
public class ScoreController_getHistoryTest {

  private MockMvc mockMvc;

  @MockBean
  private ScoreController scoreController;

  @BeforeEach
  public void setup(){
    mockMvc = MockMvcBuilders.standaloneSetup(scoreController).build();
  }

  @Test
  public void shouldBeOK_playerOnly() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/history")
      .contentType("application/json")
      .param("player", "foobar")
    ).andExpect(status().isOk());
  }

  @Test
  public void shouldBeError_NoRequiredParameter() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/history")
      .contentType("application/json")
    ).andExpect(status().isBadRequest());
  }
}