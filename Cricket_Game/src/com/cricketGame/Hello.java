package com.cricketGame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class Hello {
    private Player p1;
    private int jerseyNumber;
    public Hello(int jerseyNumber)
    {
        this.jerseyNumber = jerseyNumber;
    }

    public static String playeridentity(Hello playerDetail) {
        return playerDetail.p1.name()+"_"+playerDetail.jerseyNumber;
    }
    public static void main(String[] args) {
        Hello hell = new Hello(12);
        System.out.println(Hello.playeridentity(hell));
    }
}
