package com.cricketGame;

import java.util.Arrays;
import java.util.List;

public enum Player {
    The_Sons_of_Pitches(Arrays.asList("rahul_dravid","m_s_dhoni","virat_kohli","harbajan","sachine","dhawam","Rohit"), "Blue"),
    Bloodbath_and_Beyond(Arrays.asList("Glenn_Maxwell","Mitchell_arsh","Ashton_Agar","Watson","Aron finch","Smith","XYZ"), "Yellow"),
    The_Master_Batter(Arrays.asList("Malinga","Karunathane","Parera","kusalParera","Lakmal","Mendis","Udana"),"Green");
    private final List<String> s1;
    private final String jerserColor;
    Player(List<String> asList, String jerseyColor) {
        s1 = asList;
        this.jerserColor = jerseyColor;
    }

    public List<String> getS1() {
        return s1;
    }

    public String getJerserColor() {
        return jerserColor;
    }
}
