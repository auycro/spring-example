package com.auycro.score;

import com.auycro.score.controller.ScoreController;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScoreApplicationTests {

  @Autowired
	private ScoreController controller;

	@Test
	void contextLoads() {
    assertThat(controller).isNotNull();
	}

}
