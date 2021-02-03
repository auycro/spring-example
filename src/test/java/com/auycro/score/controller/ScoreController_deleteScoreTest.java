package com.auycro.score.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ScoreController_deleteScoreTest {
  // @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ScoreController scoreController;

  @BeforeEach
  public void setup(){
    mockMvc = MockMvcBuilders.standaloneSetup(scoreController).build();
  }

  @Test
  public void shouldBeOK() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/scores/{id}", 1L)).andExpect(status().isOk());
  }

  @Test
  public void shouldBeError_idAsString() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/scores/{id}", "A")).andExpect(status().isBadRequest());
  }

  @Test
  public void shouldBeError_NoParam() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/scores/{id}", "")).andExpect(status().is(405));
  }
}
