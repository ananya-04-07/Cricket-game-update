package com.cricketGame;

import java.util.List;

public class Inning {
    private  int over;

    public void setOver(int over) {
        this.over = over;
    }

    public int getOver() {
        return over;
    }

    public static void matchStart(String team1,String team2 , List player, Inning inning)
    {
        List<String> player1 =player.subList(0, player.size() / 2);
        List<String> player2 =player.subList(player.size() / 2, player.size());
        System.out.println(player1);
        System.out.println(player2);
        String opener1 = (player1.get(0)).toString();
        String opener2 = player1.get(1).toString();
        String baller =  (player2.get(0)).toString();
        int ballerCount = 0;

        inning.setOver(6);
        int totalBall = inning.getOver()*6;
        int wicket = 0;
        String temp;
        String temp2;
        System.out.println("========================================================");
        System.out.println("============ "+ team1 + " ready for batting ========");
        System.out.println("========================================================");
        System.out.println("============ " + opener1 + " " + opener2 + " is on pitch==");
        ScoreBoard.insertData(opener1,team1, PlayerDetailsUtil.jerseyColor(team1),"Batsman");
        ScoreBoard.insertData(opener2,team1, PlayerDetailsUtil.jerseyColor(team1),"Batsman");
        ScoreBoard.insertData(baller,team2, PlayerDetailsUtil.jerseyColor(team2),"Baller");
        int teamRun = 0;
        int ballPlayedByPlayer1 = 0;
        int ballPlayedByPlayer2 = 0;
        int ballPlayedTeam = 0;
        int ballTemp = 0;
        int runNo[] = {0,1, 2, 3, 4, 5, 6, 7};
        int probabilityOfRun[] = {20,20,10,5,10,5,5,5};
        for( ballPlayedTeam = 1;ballPlayedTeam<=totalBall;ballPlayedTeam++)
        {
            ballPlayedByPlayer1 = ballPlayedByPlayer1 + 1;
            System.out.println("========================================================");
            System.out.println("========= "+opener1 + " is on strike ===============");
            //int run = GetRandom.getRandomNumber(8);
            int run = GetRandomRun.getRun(runNo,probabilityOfRun,runNo.length);
            if(run == 7)
            {
                System.out.println("================================================");
                System.out.println("==============" + opener1 + " OUT! =========================");
                ScoreBoard.wicketUpdate(baller);
                ScoreBoard.updateBatsmanBall(opener1,ballPlayedByPlayer1);
                ScoreBoard.runCount(opener1,0,ballPlayedByPlayer1);
                System.out.println(ScoreBoard.getStrikeRate(opener1));
                wicket = wicket + 1;
                ScoreBoard.displayScore(opener1,"");
                ballPlayedByPlayer1 =ballPlayedByPlayer2;
                ballPlayedByPlayer2=0;
                opener1 = opener2;
                System.out.println("================================================");
                if(wicket == (player1.size())-1)
                    break;
                opener2 = player1.get(wicket+1).toString();
                ScoreBoard.insertData(opener2,team1, PlayerDetailsUtil.jerseyColor(team1),"Batsman");
                System.out.println("============== " + opener2 + " =================");
            }
            else if(run == 0 || run == 2 || run == 4 || run == 6) {
                System.out.println("======"+opener1 + " hits "+run+ " runs");
                ScoreBoard.runCount(opener1,run,ballPlayedByPlayer1);
            }
            else if (run == 1 || run == 3 || run == 5) {

                System.out.println("======"+opener1 + " hits "+run+ " runs");
                ScoreBoard.runCount(opener1,run,ballPlayedByPlayer1);
                ballTemp = ballPlayedByPlayer1;
                ballPlayedByPlayer1 = ballPlayedByPlayer2;
                ballPlayedByPlayer2 = ballTemp;
                temp = opener1;
                opener1 = opener2;
                opener2 = temp;

            }
            if(ballPlayedTeam%6 == 0){
                ballerCount = ballerCount+1;
                baller = player2.get(ballerCount).toString();
                ScoreBoard.insertData(baller,team2, PlayerDetailsUtil.jerseyColor(team2),"Baller");
                temp2 = opener1;
                opener1 = opener2;
                opener2 = temp2;
                ballTemp = ballPlayedByPlayer1;
                ballPlayedByPlayer1 = ballPlayedByPlayer2;
                ballPlayedByPlayer2 = ballTemp;
                System.out.println("=====" + ballPlayedTeam/6 + " over completed ================");
                ScoreBoard.displayScore(opener1,opener2);
            }


        }
        System.out.println(opener1  + ballPlayedByPlayer1);
        System.out.println(ScoreBoard.getStrikeRate(opener1));
        int totRun = ScoreBoard.getFinalScore(team1);
        TeamDetailUtil.teamRunUpdate(team1,totRun,ballPlayedTeam-1);
        TeamDetailUtil.teamRunRateUpdate((float)totRun/inning.getOver(),team1);

        System.out.println("============== SECOND INNING ============================");

        String teamTemp = team1;
        team1 = team2;
        team2 = teamTemp;
        opener1 = (player2.get(0)).toString();
        opener2 = player2.get(1).toString();
        baller =  (player1.get(0)).toString();
        ballerCount = 0;
        inning.setOver(6);
        totalBall = inning.getOver()*6;
        wicket = 0;
        System.out.println("========================================================");
        System.out.println("============ "+ team1 + " ready for batting ========");
        System.out.println("========================================================");
        System.out.println("============ " + opener1 + " " + opener2 + " is on pitch==");
        ScoreBoard.insertData(opener1,team1, PlayerDetailsUtil.jerseyColor(team1),"Batsman");
        ScoreBoard.insertData(opener2,team1, PlayerDetailsUtil.jerseyColor(team1),"Batsman");
        ScoreBoard.insertData(baller,team2, PlayerDetailsUtil.jerseyColor(team2),"Baller");
        ballPlayedByPlayer1 = 0;
        ballPlayedByPlayer2 = 0;

        for( ballPlayedTeam = 1;ballPlayedTeam<=totalBall;ballPlayedTeam++)
        {
            ballPlayedByPlayer1 = ballPlayedByPlayer1 + 1;
            System.out.println("========================================================");
            System.out.println("========= "+opener1 + " is on strike ===============");
            //int run = GetRandom.getRandomNumber(8);
            int run = GetRandomRun.getRun(runNo,probabilityOfRun,runNo.length);
            if(run == 7)
            {
                System.out.println("================================================");
                System.out.println("==============" + opener1 + " OUT! =========================");
                ScoreBoard.wicketUpdate(baller);
                ScoreBoard.updateBatsmanBall(opener1,ballPlayedByPlayer1);
                ScoreBoard.runCount(opener1,0,ballPlayedByPlayer1);
                System.out.println(ScoreBoard.getStrikeRate(opener1));
                wicket = wicket + 1;
                ScoreBoard.displayScore(opener1,"");
                ballPlayedByPlayer1 =ballPlayedByPlayer2;
                ballPlayedByPlayer2=0;
                opener1 = opener2;
                System.out.println("================================================");
                if(wicket == (player1.size())-1)
                    break;
                opener2 = player2.get(wicket+1).toString();
                ScoreBoard.insertData(opener2,team1, PlayerDetailsUtil.jerseyColor(team1),"Batsman");
                System.out.println("============== " + opener2 + " =================");
            }
            else if(run == 0 || run == 2 || run == 4 || run == 6) {
                System.out.println("======"+opener1 + " hits "+run+ " runs");
                ScoreBoard.runCount(opener1,run,ballPlayedByPlayer1);
            }
            else if (run == 1 || run == 3 || run == 5) {

                System.out.println("======"+opener1 + " hits "+run+ " runs");
                ScoreBoard.runCount(opener1,run,ballPlayedByPlayer1);
                ballTemp = ballPlayedByPlayer1;
                ballPlayedByPlayer1 = ballPlayedByPlayer2;
                ballPlayedByPlayer2 = ballTemp;
                temp = opener1;
                opener1 = opener2;
                opener2 = temp;

            }
            if(ballPlayedTeam%6 == 0){
                ballerCount = ballerCount+1;
                baller = player1.get(ballerCount).toString();
                ScoreBoard.insertData(baller,team2, PlayerDetailsUtil.jerseyColor(team2),"Baller");
                temp2 = opener1;
                opener1 = opener2;
                opener2 = temp2;
                ballTemp = ballPlayedByPlayer1;
                ballPlayedByPlayer1 = ballPlayedByPlayer2;
                ballPlayedByPlayer2 = ballTemp;
                System.out.println("=====" + ballPlayedTeam/6 + " over completed ================");
                ScoreBoard.displayScore(opener1,opener2);
            }


        }

        System.out.println(opener1  + ballPlayedByPlayer1);
        System.out.println(ScoreBoard.getStrikeRate(opener1));
        totRun = ScoreBoard.getFinalScore(team1);
        TeamDetailUtil.teamRunUpdate(team1,totRun,ballPlayedTeam);
        TeamDetailUtil.teamRunRateUpdate((float)totRun/inning.getOver(),team1);
        System.out.println(ScoreBoard.getPlayerRun("m_s_dhoni"));

    }




}
