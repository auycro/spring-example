package com.auycro.score.model;

import com.auycro.score.entity.ScoreEntity;

public class Score {

	private final long id;
  private final String player;
  private final int score;
  private final long time;

  public Score(long id, String player, int score, long time) {
    this.id = id;
    this.player = player;
    this.score = score;
    this.time = time;
  }

  public Score(ScoreEntity entity) {
    this.id = entity.getId();
    this.player = entity.getPlayer();
    this.score = entity.getScore();
    this.time = entity.getTime();    
  }

	public long getId() {
		return id;
	}

	public String getPlayer() {
		return player;
  }
  
  public int getScore() {
		return score;
  }

  public long getTime() {
		return time;
	}
}