package com.cricketGame;
import java.util.Arrays;
import java.util.List;
public enum Team {
    teamInTournament(Arrays.asList("The_Sons_of_Pitches", "Bloodbath_and_Beyond","The_Master_Batter"));
    private final List<String> teamList;

    private Team(List<String> teamplay) {
        this.teamList = teamplay;
    }

    public List<String> getTeamList() {
        return teamList;
    }
}
