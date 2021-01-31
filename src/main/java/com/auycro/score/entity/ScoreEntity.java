package com.auycro.score.entity;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.xml.bind.DatatypeConverter;

@Entity
@Table(name = "scores")
public class ScoreEntity {
  // @Id
  // @GeneratedValue(strategy=GenerationType.AUTO, generator="seq_post")
  // @SequenceGenerator(name="seq_post")
  @Id
  // @GeneratedValue(strategy=GenerationType.AUTO)
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
    this.time = toUnixTimestamp(time);
    this.hash_player = toSHA1(player);
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

  public static String toSHA1(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    String result = null;
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(input.getBytes("UTF-8"), 0, input.length());
    result = DatatypeConverter.printHexBinary(md.digest());
    return result;
  }

  public static long toUnixTimestamp(String input) throws ParseException {
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(input);
    return date.getTime() / 1000L;
  }
}
