package com.cricketGame;

public class TeamDetails {
    private String teamName;
    private String jerseyColor;
    private int runScore;
    private float runRate;
    private float over;

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setRunScore(int runScore) {
        this.runScore = runScore;
    }

    public void setRunRate(float runRate) {
        this.runRate = runRate;
    }

    public void setOver(float over) {
        this.over = over;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getRunScore() {
        return runScore;
    }

    public float getRunRate() {
        return runRate;
    }

    public float getOver() {
        return over;
    }

    public String getJerseyColor() {
        return jerseyColor;
    }

    public void setJerseyColor(String jerseyColor) {
        this.jerseyColor = jerseyColor;
    }



}
