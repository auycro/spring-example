package com.auycro.score.model;

import java.sql.Timestamp;

import com.auycro.score.entity.ScoreEntity;
import com.auycro.score.utility.DateUtility;

public class Score {

	private final long id;
  private final String player;
  private final int score;
  private final Timestamp time;

  public Score(long id, String player, int score, long time) {
    this.id = id;
    this.player = player;
    this.score = score;
    this.time = new Timestamp(time);
  }

  public Score(ScoreEntity entity) {
    this.id = entity.getId();
    this.player = entity.getPlayer();
    this.score = entity.getScore();
    this.time = new Timestamp(entity.getJavaLongTimestamp());    
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

  public Timestamp getTime() {
		return time;
  }
}