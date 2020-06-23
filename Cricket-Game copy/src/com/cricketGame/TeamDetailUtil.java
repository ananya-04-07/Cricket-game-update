package com.cricketGame;

import java.util.HashMap;

public class TeamDetailUtil {
    private static TeamDetails teamDetail;
    private static HashMap<String, TeamDetails> teamScore = new HashMap<String, TeamDetails>();

    public static void teamInsert(String team)
    {
        teamDetail = new TeamDetails();
        teamDetail.setOver(0.0f);
        teamDetail.setRunRate(0.0f);
        teamDetail.setTeam(team);
        teamDetail.setRunScore(0);
        teamScore.put(team,teamDetail);
    }
    public static void teamRunUpdate(String team,int run,int ball)
    {
        teamDetail = teamScore.get(team);
        int runprev = teamDetail.getRunScore();
        float overPlayed = (float)ball/6;
        float runRate = (float)run/overPlayed;
        teamDetail.setRunScore(run);
        teamDetail.setOver(overPlayed);
        teamDetail.setRunRate(runRate);

    }
    public static float getRunRate(String team)
    {
        teamDetail = teamScore.get(team);
        return teamDetail.getRunRate();
    }
    public static int getTeamScore(String team)
    {
        teamDetail = teamScore.get(team);
        return teamDetail.getRunScore();
    }
    public static void teamRunRateUpdate(float runrate,String team)
    {
        teamDetail = teamScore.get(team);
        teamDetail.setRunRate(runrate);
    }
    public static float teamRunRate(String team)
    {
        teamDetail = teamScore.get(team);
        return teamDetail.getRunRate();

    }
}
