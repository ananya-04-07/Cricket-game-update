package com.cricketgame;
public class main {
    public static void main(String[] args) {
        String team1 = Constant.TEAM1 ;
        String team2 = Constant.TEAM2;
        String tossWinningTeam = Util.toss(team1,team2);
        String batOrBall = Util.batOrBallDecision(tossWinningTeam);
        String temp = "";
        if(tossWinningTeam.equalsIgnoreCase(team1) && batOrBall.equalsIgnoreCase(Constant.BALLING) || (tossWinningTeam.equalsIgnoreCase(team2) && batOrBall.equalsIgnoreCase(Constant.BATTING)))
        {
            temp = team1;
            team1 = team2;
            team2 = temp;
        }
        MatchController matchController =  new MatchController(team1,team2,6);
        matchController.insertTeamDetails(team1);
        matchController.insertTeamDetails(team2);
        matchController.playerSelection(PlayerDetails.getPlayerList(team1,team2));

    }
}

