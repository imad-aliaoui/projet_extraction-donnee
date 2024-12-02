package fr.pantheonsorbonne.ufr27.miashs.poo;

import java.lang.Double;
import java.lang.Integer;
import java.lang.String;

public final class Item {
  private String name;

  private String nationality;

  private String team;

  private String league;

  private Integer yearOfBirth;

  private Integer minutesPlayed;

  private Integer goals;

  private Integer assists;

  private Double expectedGoals;

  private Integer yellowCards;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name=name;
  }

  public String getNationality() {
    return this.nationality;
  }

  public void setNationality(String nationality) {
    this.nationality=nationality;
  }

  public String getTeam() {
    return this.team;
  }

  public void setTeam(String team) {
    this.team=team;
  }

  public String getLeague() {
    return this.league;
  }

  public void setLeague(String league) {
    this.league=league;
  }

  public Integer getYearOfBirth() {
    return this.yearOfBirth;
  }

  public void setYearOfBirth(Integer yearOfBirth) {
    this.yearOfBirth=yearOfBirth;
  }

  public Integer getMinutesPlayed() {
    return this.minutesPlayed;
  }

  public void setMinutesPlayed(Integer minutesPlayed) {
    this.minutesPlayed=minutesPlayed;
  }

  public Integer getGoals() {
    return this.goals;
  }

  public void setGoals(Integer goals) {
    this.goals=goals;
  }

  public Integer getAssists() {
    return this.assists;
  }

  public void setAssists(Integer assists) {
    this.assists=assists;
  }

  public Double getExpectedGoals() {
    return this.expectedGoals;
  }

  public void setExpectedGoals(Double expectedGoals) {
    this.expectedGoals=expectedGoals;
  }

  public Integer getYellowCards() {
    return this.yellowCards;
  }

  public void setYellowCards(Integer yellowCards) {
    this.yellowCards=yellowCards;
  }
}
