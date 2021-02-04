package com.auycro.score.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.auycro.score.entity.ScoreEntity;
import com.auycro.score.utility.DateUtility;

public class Score {

	private final long id;
  private final String player;
  private final int score;
  private final String time;

  public Score(long id, String player, int score, long time) {
    this.id = id;
    this.player = player;
    this.score = score;
    this.time = convertTimestampToString(time);
  }

  public Score(ScoreEntity entity) {
    this.id = entity.getId();
    this.player = entity.getPlayer();
    this.score = entity.getScore();
    this.time = convertTimestampToString(entity.getJavaLongTimestamp());    
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

  public String getTime() {
		return time;
  }

  private String convertTimestampToString(long timestamp){
        //ISO8601 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(new Timestamp(timestamp));
  }
}