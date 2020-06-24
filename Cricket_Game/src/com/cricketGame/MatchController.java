package com.cricketGame;

import java.util.List;

public class MatchController {
    private String team1;
    private String team2;
    private List<String> player;
    private Inning inning;
    private ScoreBoard scoreBoard;
    public MatchController()
    {
        setInning(new Inning());
        setScoreBoard(new ScoreBoard());
    }
    public String getTeam1() {
        return team1;
    }
    public Inning getInning() {
        return inning;
    }
    public void setInning(Inning inning) {
        this.inning = inning;
    }
    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }
    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }
    public String getTeam2() {
        return team2;
    }
    public List<String> getPlayer() {
        return player;
    }
    public void setTeam1(String team1) {
        this.team1 = team1;
    }
    public void setTeam2(String team2) {
        this.team2 = team2;
    }


    // ----------------this function will get the list of players from player enum and call the function inning------------
    public static void matchStart(MatchController matchController,String tossWinTeam,String resultOfToss)
    {

        System.out.println("======================================================");
        System.out.println("and opted " + " " + resultOfToss);
        System.out.println("======================================================");
        System.out.println("============Match Started=============================");
        if (resultOfToss.equalsIgnoreCase(Constant.Balling)) {
            String temp = matchController.team1;
            matchController.setTeam1(matchController.team2);
            matchController.setTeam2(temp);
        }
        matchController.player = PlayerDetail.playerName(matchController.team1, matchController.team2);
        matchController.inning.InningStart(matchController);
    }


    //----------this function will select the team randomly and perform toss between them----------------
    public static void toss() {
        System.out.println("inside match");
        int t1 = TossUtil.getRandomNumber(team.values().length);
        System.out.println(t1);
        int t2;
        while (true) {
            t2 = TossUtil.getRandomNumber(team.values().length);
            if (t2 == t1)
                continue;
            else
                break;
        }
        MatchController matchController = new MatchController();
        System.out.println(t2);
        matchController.team1 = team.values()[t1].toString();
        matchController.team2 = team.values()[t2].toString();
        System.out.println(matchController.team1 + "----------" + matchController.team2 + "  Selected for match");
        String tossWinTeam = TossUtil.tossDecision(matchController.team1, matchController.team2);
        System.out.println("=========== "+ tossWinTeam + " won the toss ======= ");
        TeamDetails.teamInsert(matchController.team1,matchController);
        TeamDetails.teamInsert(matchController.team2,matchController);
        String result = TossUtil.tossForBatBall(tossWinTeam);
        if (tossWinTeam.equalsIgnoreCase(matchController.team1)) {
            MatchController.matchStart(matchController,matchController.team1,result);
        } else {
            MatchController.matchStart(matchController,matchController.team2,result);
        }

    }
}
