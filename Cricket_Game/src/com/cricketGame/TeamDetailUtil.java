package com.cricketGame;

import java.util.HashMap;

public class TeamDetailUtil {
    private  TeamDetails teamDetail;
    private TeamDetailUtil teamDetailUtil;
    private  HashMap<String, TeamDetails> teamScore = new HashMap<String, TeamDetails>();

    public TeamDetails getTeamDetail() {
        return teamDetail;
    }

    public void setTeamDetail(TeamDetails teamDetail) {
        this.teamDetail = teamDetail;
    }

    public TeamDetailUtil getTeamDetailUtil() {
        return teamDetailUtil;
    }

    public void setTeamDetailUtil(TeamDetailUtil teamDetailUtil) {
        this.teamDetailUtil = teamDetailUtil;
    }

    public HashMap<String, TeamDetails> getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(HashMap<String, TeamDetails> teamScore) {
        this.teamScore = teamScore;
    }
    public String getjerseyColor(String team)
    {
        String jerseyColor = "";
        for (Player c : Player.values()) {
            if (c.toString().equalsIgnoreCase(team)) {
                jerseyColor = c.getJerserColor();
            }
        }
        return jerseyColor;
    }
    public void teamInsert(String team,TeamDetailUtil teamDetailUtil)
    {
        setTeamDetailUtil(teamDetailUtil);
        System.out.println("hell");
        teamDetail = new TeamDetails();
        teamDetail.setJerseyColor(getTeamDetailUtil().getjerseyColor(team));
        teamDetail.setOver(0.0f);
        teamDetail.setRunRate(0.0f);
        teamDetail.setTeamName(team);
        teamDetail.setRunScore(0);
        teamScore.put(team,teamDetail);
    }
    public  void teamRunUpdate(String team,int run,int ball)
    {
        teamDetail = teamScore.get(team);
        int runprev = teamDetail.getRunScore();
        float overPlayed = (float)ball/6;
        float runRate = (float)run/overPlayed;
        teamDetail.setRunScore(run);
        teamDetail.setOver(overPlayed);
        teamDetail.setRunRate(runRate);

    }
    public  float getRunRate(String team)
    {
        teamDetail = teamScore.get(team);
        return teamDetail.getRunRate();
    }
    public  int getTeamScore(String team)
    {
        teamDetail = teamScore.get(team);
        return teamDetail.getRunScore();
    }
    public  void teamRunRateUpdate(float runrate,String team)
    {
        teamDetail = teamScore.get(team);
        teamDetail.setRunRate(runrate);
    }
    public  float teamRunRate(String team)
    {
        teamDetail = teamScore.get(team);
        return teamDetail.getRunRate();

    }
}
