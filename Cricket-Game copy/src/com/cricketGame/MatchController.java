package com.cricketGame;

import java.util.List;

public class MatchController {
    private String team1;
    private String team2;
    private static MatchController matchController = null;

    public static MatchController getInstance() {
        if (matchController == null)
            matchController = new MatchController();
        return matchController;
    }

    public void match(MatchController matchController) {
        System.out.println("inside match");
        int t1 = GetRandom.getRandomNumber(Team.values()[0].getTeamList().size());
        System.out.println(t1);
        int t2;

        while (true) {
            t2 = GetRandom.getRandomNumber(Team.values()[0].getTeamList().size());
            if (t2 == t1)
                continue;
            else
                break;
        }
        Inning inning = new Inning();
        System.out.println(t2);
        team1 = Team.values()[0].getTeamList().get(t1);
        team2 = Team.values()[0].getTeamList().get(t2);
        System.out.println(team1 + "----------" + team2 + "  Selected for match");
        String tossWinTeam = Toss.tossDecision(team1, team2);
        TeamDetailUtil.teamInsert(team1);
        TeamDetailUtil.teamInsert(team2);
        List<String> player ;
        if (tossWinTeam.equalsIgnoreCase(team1)) {
            String result = Toss.tossForBatBall(team1);
            System.out.println("======================================================");
            System.out.println("and opted " + " " + result);
            System.out.println("======================================================");
            System.out.println("============Match Started=============================");
            //System.out.println(player.subList(0,player.size()/2) + "-----" + player.subList(0,player.size()/2).size());
            //System.out.println(player.subList(player.size()/2,player.size()) + "------" +  player.subList(player.size()/2,player.size()).size());
            if (result.equalsIgnoreCase("Batting")) {
                player = PlayerDetailsUtil.playerName(team1, team2);
                Inning.matchStart(team1, team2, player,  inning);
            } else {
                player = PlayerDetailsUtil.playerName(team2, team1);
                Inning.matchStart(team1, team2, player,  inning);
            }
        }
        else {
            String result = Toss.tossForBatBall(team1);
            System.out.println("======================================================");
            System.out.println("and  opted " + " " + result );
            System.out.println("======================================================");
            System.out.println("============Match Started=============================");
            System.out.println("======================================================");
            //System.out.println(player.subList(0,player.size()/2)+"--------"+player.subList(0,player.size()/2).size());
            //System.out.println(player.subList(player.size()/2,player.size())+"---------"+player.subList(player.size()/2,player.size()).size());
            if (result.equalsIgnoreCase("Batting")) {
                player = PlayerDetailsUtil.playerName(team2, team1);
                Inning.matchStart(team2, team1, player,  inning);}
            else
            {
                player = PlayerDetailsUtil.playerName(team1, team2);
                Inning.matchStart(team1, team2, player,  inning);
            }
        }
        System.out.println(team1 + " ------- "+TeamDetailUtil.getTeamScore(team1));
        System.out.println(team2 + " ------- "+TeamDetailUtil.getTeamScore(team2));
        System.out.println(ScoreBoard.getFinalScore(team1));
        System.out.println(ScoreBoard.getFinalScore(team2));




    }

    public static void main (String[]args){
        MatchController m1 = getInstance();
        m1.match(m1);
    }
}
