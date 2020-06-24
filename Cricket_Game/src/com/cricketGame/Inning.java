package com.cricketGame;

import java.util.List;

public class Inning {
    private int over;

    public void setOver(int over) {
        this.over = over;
    }

    public int getOver() {
        return over;
    }

    public void batting(String team1, String team2, List<String> player1, List<String> player2, MatchController matchController) {
        String opener1 = (player1.get(0));
        String opener2 = player1.get(1);
        String baller = (player2.get(0));
        int ballerCount = 0;
        System.out.println("========================================================");
        System.out.println("============ " + opener1 + " " + opener2 + " is on pitch==");
        matchController.getInning().setOver(6);
        int totalBall = matchController.getInning().getOver() * 6;
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
            int run = TossUtil.getRun(runNo, probabilityOfRun, runNo.length);
            if (run == 7) {
                System.out.println("================================================");
                System.out.println("==============" + opener1 + " OUT! =========================");
                matchController.getScoreBoard().wicketUpdate(baller);
                matchController.getScoreBoard().updateBatsmanBall(opener1, ballPlayedByPlayer1);
                matchController.getScoreBoard().runCount(opener1, 0, ballPlayedByPlayer1);
                System.out.println(matchController.getScoreBoard().getStrikeRate(opener1));
                wicket = wicket + 1;
                matchController.getScoreBoard().displayScore(opener1, "");
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
                matchController.getScoreBoard().runCount(opener1, run, ballPlayedByPlayer1);
            } else if (run == 1 || run == 3 || run == 5) {

                System.out.println("======" + opener1 + " hits " + run + " runs");
                matchController.getScoreBoard().runCount(opener1, run, ballPlayedByPlayer1);
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
                matchController.getScoreBoard().displayScore(opener1, opener2);
            }
        }
        int totRun = matchController.getScoreBoard().getTeamFinalScore(team1);
        matchController.getScoreBoard().teamRunUpdate(team1, totRun, ballPlayedTeam);
        matchController.getScoreBoard().teamRunRateUpdate((float) totRun / matchController.getInning().getOver(), team1);
    }

    public void InningStart(MatchController matchController) {
        matchController.getScoreBoard().setScoreBoard(matchController.getScoreBoard());
        List<String> player1 = matchController.getPlayer().subList(0, matchController.getPlayer().size() / 2);
        PlayerDetail.insertPlayerDetail(matchController.getPlayer(), matchController);
        List<String> player2 = matchController.getPlayer().subList(matchController.getPlayer().size() / 2, matchController.getPlayer().size());
        System.out.println(player1);
        System.out.println(player2);
        System.out.println("========================================================");
        System.out.println("============ " + matchController.getTeam1() + " ready for batting ========");
        matchController.getInning().batting(matchController.getTeam1(), matchController.getTeam2(), player1, player2, matchController);
        System.out.println("============== SECOND INNING ============================");
        System.out.println("========================================================");
        System.out.println("============ " + matchController.getTeam2() + " ready for batting ========");
        System.out.println("========================================================");
        matchController.getInning().batting(matchController.getTeam2(), matchController.getTeam2(), player2, player1, matchController);
    }
}
