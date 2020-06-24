package com.cricketGame;

public class MainClass {

    private static MainClass mainClass = null;

    public static MainClass getInstance() {
        if (mainClass == null)
            mainClass = new MainClass();
        return mainClass;
    }

    public static void main(String[] args) {
        MainClass m1 = getInstance();
        MatchController.toss();
    }
}
