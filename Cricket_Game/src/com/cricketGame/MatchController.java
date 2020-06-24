package com.cricketGame;

import java.util.List;

public class MatchController {
    private String team1;
    private String team2;
    private List<String> player;
    private Inning inning;
    private ScoreBoard scoreBoard;
    private TeamDetailUtil teamDetailUtil;
    private PlayerDetailsUtil playerDetailsUtil;
    public MatchController()
    {
        setInning(new Inning());
        setScoreBoard(new ScoreBoard());
        setTeamDetailUtil(new TeamDetailUtil());
    }

    public void setPlayerDetailsUtil(PlayerDetailsUtil playerDetailsUtil) {
        this.playerDetailsUtil = playerDetailsUtil;
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
    public TeamDetailUtil getTeamDetailUtil() {
        return teamDetailUtil;
    }

    public void setTeamDetailUtil(TeamDetailUtil teamDetailUtil) {
        this.teamDetailUtil = teamDetailUtil;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public static void matchStart(MatchController matchController,String tossWinTeam)
    {
        String result = Toss.tossForBatBall(tossWinTeam);
        System.out.println("======================================================");
        System.out.println("and opted " + " " + result);
        System.out.println("======================================================");
        System.out.println("============Match Started=============================");
        if (result.equalsIgnoreCase(ConstantClass.Balling)) {
            String temp = matchController.team1;
            matchController.setTeam1(matchController.team2);
            matchController.setTeam2(temp);
        }
        matchController.player = PlayerDetailsUtil.playerName(matchController.team1, matchController.team2);
        matchController.inning.inningStart(matchController);
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
        MatchController matchController = new MatchController();
        System.out.println(t2);
        matchController.team1 = Team.values()[0].getTeamList().get(t1);
        matchController.team2 = Team.values()[0].getTeamList().get(t2);
        System.out.println(matchController.team1 + "----------" + matchController.team2 + "  Selected for match");
        String tossWinTeam = Toss.tossDecision(matchController.team1, matchController.team2);
        System.out.println("=========== "+ tossWinTeam + " won the toss ======= ");
        System.out.println(matchController.getTeamDetailUtil());
        matchController.getTeamDetailUtil().teamInsert(matchController.team1,matchController.getTeamDetailUtil());
        matchController.getTeamDetailUtil().teamInsert(matchController.team2,matchController.getTeamDetailUtil());
        if (tossWinTeam.equalsIgnoreCase(matchController.team1)) {
            MatchController.matchStart(matchController,matchController.team1);
        } else {
            MatchController.matchStart(matchController,matchController.team2);
        }

    }
}
