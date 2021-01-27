package com.auycro.score;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScoreApplicationTests {

	@Test
	void contextLoads() {
	}

  String a = "aaaadddd";

  @Test
  @DisplayName("Test jUnit Version")
  void testJUnit() {
    assertEquals("aaaaa", a);
  }

}
