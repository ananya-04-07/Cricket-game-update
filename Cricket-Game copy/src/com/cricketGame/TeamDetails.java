package com.cricketGame;

public class TeamDetails {
    private String team;
    private int runScore;
    private float runRate;
    private float over;

    public void setTeam(String team) {
        this.team = team;
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

    public String getTeam() {
        return team;
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


}
