package com.cricketGame;

import java.util.HashMap;

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

    public int getRunScore() {
        return runScore;
    }

    public float getRunRate() {
        return runRate;
    }

    public void setJerseyColor(String jerseyColor) {
        this.jerseyColor = jerseyColor;
    }

    public static String getjerseyColor(String team)
    {
        String jerseyColor = "";
        for (com.cricketGame.team c : com.cricketGame.team.values()) {
            if (c.toString().equalsIgnoreCase(team)) {
                jerseyColor = c.getJerserColor();
            }
        }
        return jerseyColor;
    }
    public static void teamInsert(String team, MatchController matchController)
    {
        System.out.println("hell");
        TeamDetails teamDetail = new TeamDetails();
        teamDetail.setJerseyColor(getjerseyColor(team));
        teamDetail.setOver(0.0f);
        teamDetail.setRunRate(0.0f);
        teamDetail.setTeamName(team);
        teamDetail.setRunScore(0);
        matchController.getScoreBoard().getTeamScoreDrtail().put(team,teamDetail);


    }

}
