package com.auycro.score.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.auycro.score.utility.DateUtility;
import com.auycro.score.utility.StringUtility;

@Entity
@Table(name = "scores")
public class ScoreEntity {
  @Id
  @Column(name = "id")
  private long id;

  @Column(name = "player")
  private String player;

  @Column(name = "hash_player")
  private String hash_player;

  @Column(name = "score")
  private int score;

  @Column(name = "time")
  private long time;

  public ScoreEntity() {
  }

  public ScoreEntity(String player, int score, String time) throws Exception {
    this.player = player;
    this.score = score;
    this.time = DateUtility.toUnixTimestamp(time);
    this.hash_player = StringUtility.toMD5(player);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPlayer() {
    return player;
  }

  public void setPlayer(String player) {
    this.player = player.toLowerCase();
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }
}
