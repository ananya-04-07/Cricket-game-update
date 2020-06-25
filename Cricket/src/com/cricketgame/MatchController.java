package com.cricketgame;

import java.util.HashMap;
import java.util.List;

public class MatchController {
    private String team1;
    private String team2;
    private int over;
    private PlayerDetails playerDetails;
    private TeamDetails teamDetails;
    private HashMap<String, PlayerDetails> playersScore = new HashMap<>();
    private HashMap<String, TeamDetails> teamsScore = new HashMap<>();

    public MatchController(String team1, String team2, int over) {
        this.team1 = team1;
        this.team2 = team2;
        this.over = over;
    }

    public int matchtStart(List<String> player1, List<String> player2) {
        String opener1 = (player1.get(0));
        String opener2 = player1.get(1);
        String baller = (player2.get(0));
        int ballerCount = 0;
        int totalBall = over * 6;
        int wicket = 0;
        String temp;
        String temp2;
        int ballPlayedByPlayer1 = 0;
        int ballPlayedByPlayer2 = 0;
        int ballPlayedTeam = 0;
        int ballTemp = 0;
        int runNo[] = {0, 1, 2, 3, 4, 5, 6, 7};
        int probabilityOfRun[] = {20, 20, 10, 5, 10, 5, 5, 5};
        for (ballPlayedTeam = 1; ballPlayedTeam <= totalBall; ballPlayedTeam++) {
            ballPlayedByPlayer1 = ballPlayedByPlayer1 + 1;
            System.out.println("========================================================");
            System.out.println("========= " + opener1 + " is on strike ===============");
            int run = Util.getRun(runNo, probabilityOfRun, runNo.length);
            if (run == 7) {
                System.out.println("================================================");
                System.out.println("==============" + opener1 + " OUT! =========================");
                playerWicketUpdate(baller);
                updateBatsmanBall(opener1, ballPlayedByPlayer1);
                playerRunCount(opener1, 0, ballPlayedByPlayer1);
                System.out.println(getStrikeRate(opener1));
                wicket = wicket + 1;
                displayScoreOfPlayer(opener1, "");
                ballPlayedByPlayer1 = ballPlayedByPlayer2;
                ballPlayedByPlayer2 = 0;
                opener1 = opener2;
                System.out.println("================================================");
                if (wicket == (player1.size()) - 1)
                    break;
                opener2 = player1.get(wicket + 1);
                System.out.println("============== " + opener2 + " =================");
            } else if (run == 0 || run == 2 || run == 4 || run == 6) {
                System.out.println("======" + opener1 + " hits " + run + " runs");
                playerRunCount(opener1, run, ballPlayedByPlayer1);
            } else if (run == 1 || run == 3 || run == 5) {

                System.out.println("======" + opener1 + " hits " + run + " runs");
                playerRunCount(opener1, run, ballPlayedByPlayer1);
                ballTemp = ballPlayedByPlayer1;
                ballPlayedByPlayer1 = ballPlayedByPlayer2;
                ballPlayedByPlayer2 = ballTemp;
                temp = opener1;
                opener1 = opener2;
                opener2 = temp;

            }
            if (ballPlayedTeam % 6 == 0) {
                ballerCount = ballerCount + 1;
                baller = player2.get(ballerCount);
                temp2 = opener1;
                opener1 = opener2;
                opener2 = temp2;
                ballTemp = ballPlayedByPlayer1;
                ballPlayedByPlayer1 = ballPlayedByPlayer2;
                ballPlayedByPlayer2 = ballTemp;
                System.out.println("=====" + ballPlayedTeam / 6 + " over completed ================");
                displayScoreOfPlayer(opener1, opener2);
            }
        }
        return ballPlayedTeam;
    }

    public void playerSelection(List<String> players) {
        insertPlayerDetails(players);
        teamScoreBoardDisplay();
        List<String> player1 = players.subList(0, players.size() / 2);
        List<String> player2 = players.subList(players.size() / 2, players.size());
        System.out.println(player1);
        System.out.println(player2);
        int ballPlayedTeam = 0;
        System.out.println("============= FISRT INNING==================================");
        ballPlayedTeam = matchtStart(player1, player2);
        int totRunTeam1 = getTeamFinalScore(team1);
        teamRunUpdate(team1, totRunTeam1, ballPlayedTeam);
        System.out.println("============= SECOND INNING=================================");
        ballPlayedTeam = matchtStart(player2, player1);
        int totRunTeam2 = getTeamFinalScore(team2);
        teamRunUpdate(team2, totRunTeam2, ballPlayedTeam);
        teamScoreBoardDisplay();
    }

    public void insertPlayerDetails(List<String> players) {
        PlayerDetails playerDetail;
        for (int i = 0; i < players.size(); i++) {
            if (i < players.size() / 2) {
                playerDetail = new PlayerDetails.PlayerBuilder(players.get(i), Constant.BATTING, Util.getJerseyColor(team1), team1, i).player();
            } else
                playerDetail = new PlayerDetails.PlayerBuilder(players.get(i), Constant.BALLING, Util.getJerseyColor(team2), team2, i).player();
            String playerId = Util.getUniquePlayerId(players.get(i), playerDetail.getJerseyNumber());
            playersScore.put(playerId, playerDetail);
        }
    }

    public void insertTeamDetails(String team) {
        TeamDetails teamDetail = new TeamDetails.TeamDetailBuilder(team, Util.getJerseyColor(team)).team();
        teamsScore.put(team, teamDetail);
    }

    public void playerRunCount(String playerName, int run, int ballFaced) {
        String playerId = Util.getPlayerNameFromId(playersScore, playerName);
        playerDetails = playersScore.get(playerId);
        System.out.println(playerDetails.getRun() + run);
        int runplay = playerDetails.getRun() + run;
        playerDetails.setRun(runplay);
        if (ballFaced != 0) {
            System.out.println(ballFaced);
            playerDetails.setStrikeRate((runplay * 100) / ballFaced);
        }
    }

    public void displayScoreOfPlayer(String player1, String player2) {

        String player1Id = Util.getPlayerNameFromId(playersScore, player1);
        if (player2.equals("")) {
            System.out.println("===========================================");
            System.out.print("=========Final Score of " + player1 + "======>  ");
            System.out.println(playersScore.get(player1Id).getRun());
        } else {
            String player2Id = Util.getPlayerNameFromId(playersScore, player2);
            System.out.println("===========================================");
            System.out.print("========= Score of " + player1 + " after over ======>  ");
            System.out.println(playersScore.get(player1Id).getRun()
            );
            System.out.print("========= Score of " + player2 + " after over ======>  ");
            System.out.println(playersScore.get(player2Id).getRun());
        }
    }

    public int getTeamFinalScore(String team) {
        int sum = 0;
        for (PlayerDetails player : playersScore.values()) {
            if (player.getTeamName().equalsIgnoreCase(team))
                sum = sum + player.getRun();
        }
        return sum;
    }

    public void playerWicketUpdate(String player) {
        String playerId = Util.getPlayerNameFromId(playersScore, player);
        playerDetails = playersScore.get(playerId);
        int wicket = playerDetails.getWicket();
        playerDetails.setWicket(wicket + 1);

    }

    public void updateBatsmanBall(String playerName, int ballPlayedByPlayer1) {
        String playerId = Util.getPlayerNameFromId(playersScore, playerName);
        playerDetails = playersScore.get(playerId);
        float overPlay = playerDetails.getOverPlayed();
        float totalOver = (float) ballPlayedByPlayer1 / 6 + overPlay;
        playerDetails.setOverPlayed(totalOver);
    }

    public float getStrikeRate(String playerName) {
        String playerId = Util.getPlayerNameFromId(playersScore, playerName);
        PlayerDetails pd = playersScore.get(playerId);
        return pd.getStrikeRate();
    }

    public int getPlayerRun(String playerName) {
        String playerId = Util.getPlayerNameFromId(playersScore, playerName);
        PlayerDetails pd = playersScore.get(playerId);
        return pd.getRun();
    }

    public void teamRunUpdate(String team, int run, int ball) {
        System.out.println(team);
        teamDetails = teamsScore.get(team);
        int runprev = teamDetails.getRunScore();
        float overPlayed = (float) ball / 6;
        float runRate = (float) (run + runprev) / overPlayed;
        teamDetails.setRunScore(run);
        teamDetails.setOverPlayed(overPlayed);
        teamDetails.setRunRate(runRate);

    }

    public float getRunRate(String team) {
        teamDetails = teamsScore.get(team);
        return teamDetails.getRunRate();
    }

    public int getTeamScore(String team) {
        teamDetails = teamsScore.get(team);
        return teamDetails.getRunScore();
    }

    public void teamScoreBoardDisplay() {
        for (TeamDetails tm : teamsScore.values()) {
            System.out.println(tm.getTeamName() + "  " + tm.getJerseyColor() + "  " + tm.getRunScore() + "  " + tm.getRunRate() + "  " + tm.getOverPlayed());
        }
    }

}

