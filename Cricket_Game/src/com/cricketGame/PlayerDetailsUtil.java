package com.cricketGame;

import java.util.ArrayList;
import java.util.List;

public class PlayerDetailsUtil {
    private Player play;
    private int run;
    private float overPlayed;
    private float strikeRate;
    private int wicketTaken;
    private int ballBowled;
    private String playerType;
    private String Name;
    private String teamName;
    private int jerseyNumber;
    private String jerseyColor;

    public String getJerseyColor() {
        return jerseyColor;
    }

    public void setJerseyColor(String jerseyColor) {
        this.jerseyColor = jerseyColor;
    }

    public void setPlay(Player play) {
        this.play = play;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public void setOverPlayed(float overPlayed) {
        this.overPlayed = overPlayed;
    }

    public void setStrikeRate(float strikeRate) {
        this.strikeRate = strikeRate;
    }

    public void setWicketTaken(int wicketTaken) {
        this.wicketTaken = wicketTaken;
    }

    public void setBallBowled(int ballBowled) {
        this.ballBowled = ballBowled;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public Player getPlay() {
        return play;
    }

    public int getRun() {
        return run;
    }

    public float getOverPlayed() {
        return overPlayed;
    }

    public float getStrikeRate() {
        return strikeRate;
    }

    public int getWicketTaken() {
        return wicketTaken;
    }

    public int getBallBowled() {
        return ballBowled;
    }

    public String getPlayerType() {
        return playerType;
    }

    public String getName() {
        return Name;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public static String playeridentity(PlayerDetailsUtil playerDetail) {
        return playerDetail.getPlay().name() + "_" + playerDetail.jerseyNumber;
    }


    public static List playerName(String team1, String team2) {
        List<String> playerName = new ArrayList<>();
        for (Player c : Player.values()) {
            if (c.toString().equalsIgnoreCase(team1)) {
                playerName.addAll(c.getS1());
            }
        }
        for (Player c : Player.values()) {
            if (c.toString().equalsIgnoreCase(team2)) {
                playerName.addAll(c.getS1());
            }
        }
        System.out.println(playerName);
        return playerName;
    }


    public String jerseyColor(String team) {
        String color = "";
        for (Player c : Player.values()) {
            if (c.toString().equalsIgnoreCase(team)) {
                color = c.getJerserColor();
            }
        }
        return color;
    }
    public PlayerDetailsUtil insertPlayerDetailUtil(String team,String playerName,String playerType)
    {
        PlayerDetailsUtil playerDetail = new PlayerDetailsUtil();
        playerDetail.setTeamName(team);
        playerDetail.setOverPlayed(0);
        playerDetail.setName(playerName);
        playerDetail.setBallBowled(0);
        playerDetail.setRun(0);
        playerDetail.setWicketTaken(0);
        playerDetail.setStrikeRate(0.0f);
        playerDetail.setPlayerType(playerType);
        playerDetail.setJerseyColor(jerseyColor(team));
        return playerDetail;
    }
    public void insertPlayerDetail(List<String> players, MatchController matchController) {
        ScoreBoard scoreBoard = matchController.getScoreBoard();
        PlayerDetailsUtil playerDetail;
        for(int i = 0;i < players.size();i++)
        {
            if(i<players.size()/2) {
                 playerDetail = insertPlayerDetailUtil(matchController.getTeam1(), players.get(i), ConstantClass.Batting);
            }
            else
                 playerDetail = insertPlayerDetailUtil(matchController.getTeam2(), players.get(i), ConstantClass.Balling);
            scoreBoard.getScore().put(players.get(i), playerDetail);
        }

    }

}
