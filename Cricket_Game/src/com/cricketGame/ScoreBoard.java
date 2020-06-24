package com.cricketGame;
import java.util.*;


public class ScoreBoard {
    private PlayerDetailsUtil playerDetail;
    private ScoreBoard scoreBoard;
    private HashMap<String, PlayerDetailsUtil> score = new HashMap<String, PlayerDetailsUtil>();
    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }
    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }
    public void setScore(HashMap<String, PlayerDetailsUtil> score) {
        this.score = score;
    }
    public HashMap<String, PlayerDetailsUtil> getScore() {
        return score;
    }
    public void runCount(String playerName, int run , int ballFaced)
    {
        playerDetail = getScoreBoard().score.get(playerName);
        System.out.println(playerDetail.getRun()+run);
        int runplay= playerDetail.getRun() + run;
        playerDetail.setRun(runplay);
        if(ballFaced != 0 ) {
            System.out.println(ballFaced);
            playerDetail.setStrikeRate((runplay *100)/ ballFaced);
        }
    }
    public void displayScore(String player1, String player2)
    {
            if(player2.equals("")) {
                System.out.println("===========================================");
                System.out.print("=========Final Score of " + player1 + "======>  ");
                System.out.println(getScoreBoard().score.get(player1).getRun());
            }
            else
            {
                System.out.println("===========================================");
                System.out.print("========= Score of " + player1 + " after over ======>  ");
                System.out.println(getScoreBoard().score.get(player1).getRun());
                System.out.print("========= Score of " + player2 + " after over ======>  ");
                System.out.println(getScoreBoard().score.get(player2).getRun());
            }
    }
    public int getTeamFinalScore(String team)
    {
        int sum = 0;
        for (PlayerDetailsUtil player : getScoreBoard().score.values()) {
            if(player.getTeamName().equalsIgnoreCase(team))
                sum = sum+player.getRun();
        }
        return sum;
    }
    public void wicketUpdate(String player)
    {
        playerDetail = getScoreBoard().score.get(player);
        int wicket = playerDetail.getWicketTaken();
        playerDetail.setWicketTaken(wicket+1);

    }
    public void updateBatsmanBall(String playerName, int ballPlayedByPlayer1) {
        playerDetail = new PlayerDetailsUtil();
        playerDetail = getScoreBoard().score.get(playerName);
        float overPlay= playerDetail.getOverPlayed();
        float totalOver = (float)ballPlayedByPlayer1/6 + overPlay;
        playerDetail.setOverPlayed(totalOver);
    }
    public float getStrikeRate(String opener1) {

        PlayerDetailsUtil pd =  getScoreBoard().score.get(opener1);
        return pd.getStrikeRate();
    }
    public  int getPlayerRun(String playerName)
    {
        PlayerDetailsUtil pd = getScoreBoard().score.get(playerName);
        return pd.getRun();
    }
}
