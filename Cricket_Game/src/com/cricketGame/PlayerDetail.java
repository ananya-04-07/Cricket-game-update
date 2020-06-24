package com.cricketGame;

import java.util.ArrayList;
import java.util.List;

public class PlayerDetail {
    private int run;
    private String playerName;
    private float overPlayed;
    private float strikeRate;
    private int wicket;
    private int ballBowled;
    private String playerType;
    private String teamName;
    private int jerseyNumber;
    private String jerseyColor;

    public String getJerseyColor() {
        return jerseyColor;
    }

    public void setJerseyColor(String jerseyColor) {
        this.jerseyColor = jerseyColor;
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

    public void setWicket(int wicketTaken) {
        this.wicket = wicketTaken;
    }

    public void setBallBowled(int ballBowled) {
        this.ballBowled = ballBowled;
    }

     public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
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

    public int getWicket() {
        return wicket;
    }

    public int getBallBowled() {
        return ballBowled;
    }

    public String getPlayerType() {
        return playerType;
    }

     public String getTeamName() {
        return teamName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public static List<String> playerName(String team1, String team2) {
        List<String> playerName = new ArrayList<>();
        for (team c : team.values()) {
            if (c.toString().equalsIgnoreCase(team1)) {
                playerName.addAll(c.getPlayerList());
            }
        }
        for (team c : team.values()) {
            if (c.toString().equalsIgnoreCase(team2)) {
                playerName.addAll(c.getPlayerList());
            }
        }
        System.out.println(playerName);
        return playerName;
    }


    public static String jerseyColor(String team) {
        String color = "";
        for (com.cricketGame.team c : com.cricketGame.team.values()) {
            if (c.toString().equalsIgnoreCase(team)) {
                color = c.getJerserColor();
            }
        }
        return color;
    }
    public static class PlayerBuilder
    {
        private String playerName;
        private String playerType;
        private String jerseyColor;
        private int run;
        private float overPlayed;
        private float strikeRate;
        private int wicket;
        private int ballBowled;
        private String teamName;
        private int jerseyNumber;

        public PlayerBuilder(String playerName, String playerType, String jerseyColor, String teamName)
        {
            this.playerName = playerName;
            this.playerType = playerType;
            this.jerseyColor= jerseyColor;
            this.teamName = teamName;
        }

        public PlayerBuilder run(int val)
        { run = val;      return this; }
        public PlayerBuilder overPlayed(float val)
        { overPlayed = val;           return this; }
        public PlayerBuilder strikeRate(float val)
        { strikeRate = val;        return this; }
        public PlayerBuilder wicket(int val)
        { wicket = val;  return this; }
        public PlayerBuilder ballBowled(int val)
        { ballBowled = val;      return this; }
        public PlayerBuilder overPlayed(int val)
        { overPlayed = val;           return this; }

        public PlayerDetail player()
        {
            return new PlayerDetail(this);
        }

    }
    private PlayerDetail(PlayerBuilder playerbuilder)
    {
        this.playerName = playerbuilder.playerName;
        this.playerType = playerbuilder.playerType;
        this.jerseyColor = playerbuilder.jerseyColor;
        this.run  = playerbuilder.run;
        this.overPlayed = playerbuilder.overPlayed;
        this.strikeRate = playerbuilder.strikeRate;
        this.wicket = playerbuilder.wicket;
        this.ballBowled = playerbuilder.ballBowled;
        this.teamName = playerbuilder.teamName;
        this.jerseyNumber = playerbuilder.jerseyNumber;
    }
    public static void insertPlayerDetail(List<String> players, MatchController matchController) {
        ScoreBoard scoreBoard = matchController.getScoreBoard();
        PlayerDetail playerDetail;
        for(int i = 0;i < players.size();i++)
        {
            if(i<players.size()/2) {
                 playerDetail = new PlayerDetail.PlayerBuilder(players.get(i), Constant.Batting,jerseyColor(matchController.getTeam1()),matchController.getTeam1()).player();
            }
            else
                playerDetail = new PlayerDetail.PlayerBuilder(players.get(i), Constant.Balling,jerseyColor(matchController.getTeam2()),matchController.getTeam1()).player();
            scoreBoard.getScore().put(players.get(i), playerDetail);
        }

    }

}
