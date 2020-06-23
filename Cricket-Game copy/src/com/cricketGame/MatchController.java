package com.cricketGame;

import java.util.List;

public class MatchController {
    private static String team1;
    private static String team2;
    private static List<String> player;
    public static void matchStart(String team1, String team2, Inning inning)
    {
        String result = Toss.tossForBatBall(team1);
        System.out.println("======================================================");
        System.out.println("and opted " + " " + result);
        System.out.println("======================================================");
        System.out.println("============Match Started=============================");
        if (result.equalsIgnoreCase(ConstantClass.Batting)) {
            player = PlayerDetailsUtil.playerName(team1, team2);
            Inning.matchStart(team1, team2, player, inning);
        } else {
            player = PlayerDetailsUtil.playerName(team2, team1);
            Inning.matchStart(team2, team1, player, inning);
        }
    }

    public static void match() {
        System.out.println("inside match");
        int t1 = GetRandomUtil.getRandomNumber(Team.values()[0].getTeamList().size());
        System.out.println(t1);
        int t2;
        while (true) {
            t2 = GetRandomUtil.getRandomNumber(Team.values()[0].getTeamList().size());
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
        System.out.println("=========== "+ tossWinTeam + " won the toss ======= ");
        if (tossWinTeam.equalsIgnoreCase(team1)) {
            MatchController.matchStart(team1,team2,inning);
        } else {
            MatchController.matchStart(team2,team1,inning);
        }
        System.out.println(team1 + " ------- " + TeamDetailUtil.getTeamScore(team1));
        System.out.println(team2 + " ------- " + TeamDetailUtil.getTeamScore(team2));
        System.out.println(ScoreBoard.getFinalScore(team1));
        System.out.println(ScoreBoard.getFinalScore(team2));


    }


}
