package com.cricketGame;
import java.util.*;


public class ScoreBoard {
    private static PlayerDetailsUtil playerDetail;
    private static ScoreBoard scoreBoard = null;
    private static HashMap<String, PlayerDetailsUtil> score = new HashMap<String, PlayerDetailsUtil>();
    public static ScoreBoard getInstance() {
        if (scoreBoard == null)
            scoreBoard = new ScoreBoard();
        return scoreBoard;
    }
    public static void runCount(String playerName, int run , int ballFaced)
    {
        scoreBoard = ScoreBoard.getInstance();
        playerDetail = new PlayerDetailsUtil();
        playerDetail = ScoreBoard.score.get(playerName);
        System.out.println(playerDetail.getRun()+run);
        int runplay= playerDetail.getRun() + run;
        playerDetail.setRun(runplay);
        if(ballFaced != 0 ) {
            System.out.println(ballFaced);
            playerDetail.setStrikeRate((runplay *100)/ ballFaced);
        }
    }
    public static void displayScore(String player1, String player2)
    {
            scoreBoard = ScoreBoard.getInstance();
            if(player2.equals("")) {
                System.out.println("===========================================");
                System.out.print("=========Final Score of " + player1 + "======>  ");
                System.out.println(ScoreBoard.score.get(player1).getRun());
            }
            else
            {
                System.out.println("===========================================");
                System.out.print("========= Score of " + player1 + " after over ======>  ");
                System.out.println(ScoreBoard.score.get(player1).getRun());
                System.out.print("========= Score of " + player2 + " after over ======>  ");
                System.out.println(ScoreBoard.score.get(player2).getRun());
            }
    }
    public static void insertData(String player1,String team,String jersey,String playerType)
    {
        scoreBoard = ScoreBoard.getInstance();
        if(!score.containsKey(player1)) {
            playerDetail = new PlayerDetailsUtil();
            playerDetail.setTeamName(team);
            playerDetail.setJerseyColor(jersey);
            playerDetail.setOverPlayed(0);
            playerDetail.setName(player1);
            playerDetail.setBallBowled(0);
            playerDetail.setRun(0);
            playerDetail.setWicketTaken(0);
            playerDetail.setStrikeRate(0.0f);
            playerDetail.setPlayerType(playerType);
            scoreBoard.score.put(player1, playerDetail);
        }
    }
    public static int getFinalScore(String team)
    {
        scoreBoard = ScoreBoard.getInstance();
        int sum = 0;
        for (PlayerDetailsUtil f : ScoreBoard.score.values()) {
            if(f.getTeamName().equalsIgnoreCase(team))
                sum = sum+f.getRun();
        }
        return sum;

    }
    public static void wicketUpdate(String player)
    {
        scoreBoard = ScoreBoard.getInstance();
        playerDetail = ScoreBoard.score.get(player);
        int wicket = playerDetail.getWicketTaken();
        playerDetail.setWicketTaken(wicket+1);

    }

    public static void updateBatsmanBall(String playerName, int ballPlayedByPlayer1) {
        scoreBoard = ScoreBoard.getInstance();
        playerDetail = new PlayerDetailsUtil();
        playerDetail = ScoreBoard.score.get(playerName);
        float overPlay= playerDetail.getOverPlayed();
        float totalOver = (float)ballPlayedByPlayer1/6 + overPlay;
        playerDetail.setOverPlayed(totalOver);
    }

    public static float getStrikeRate(String opener1) {
        PlayerDetailsUtil pd =  ScoreBoard.score.get(opener1);
        return pd.getStrikeRate();
    }

    public static int getPlayerRun(String playerName)
    {
        PlayerDetailsUtil pd = ScoreBoard.score.get(playerName);
        return pd.getRun();
    }
}
