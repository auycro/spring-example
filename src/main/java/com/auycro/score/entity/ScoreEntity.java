package com.auycro.score.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="scores")
public class ScoreEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
  private long id;

  @Column(name="player")
  private String player;

  @Column(name="hash_player")
  private String hash_player;

  @Column(name="score")
  private int score;

  @Column(name="time")
  private Timestamp time;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPlayer() {
    return player;
  }

  public static String toSHA1(byte[] convertme) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA-1");
    return Base64.getEncoder().encodeToString(md.digest(convertme));
  }

  public void setPlayer(String player) {
    this.player = player.toLowerCase();
    try{
      this.hash_player = toSHA1(this.player.getBytes());
    } catch (Exception e){
      System.out.println(e);
    }
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

}
