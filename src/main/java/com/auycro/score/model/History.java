package com.auycro.score.model;

import java.util.Comparator;
import java.util.List;

public class History {

  /*
   * top score (time and score) which the best ever score of the player. low score
   * (time and score) worst score of the player. average score value for player
   * list of all the scores (time and score) of this player.
   */

  private final String player;
  private final Score topScore;
  private final Score lowScore;
  private final double average;
  private final List<Score> scores;

  public History(String player, Score topScore, Score lowScore, double average, List<Score> scores) {
    this.player = player;
    this.topScore = topScore;
    this.lowScore = lowScore;
    this.average = average;
    this.scores = scores;
  }

  public History(List<Score> scores) {
    this.scores = scores;
    this.player = scores.get(0).getPlayer();
    this.topScore = scores.stream().max(Comparator.comparing(Score::getScore)).get();
    this.lowScore = scores.stream().min(Comparator.comparing(Score::getScore)).get();
    this.average = this.calculateAverage();
  }

  public String getPlayer(){
    return player;
  }
  
  public Score getTopScore(){
    return topScore;
  }

  public Score getLowScore(){
    return lowScore;
  }

  public Double getAverage(){
    return average;
  }

  public List<Score> getScore() {
		return scores;
  }

  private double calculateAverage(){
    long sum = 0;
    List<Score> scores = getScore();
    for(int i=0;i<scores.size();i++){
      sum += scores.get(i).getScore();
    }
    return sum/scores.size();
  }
}