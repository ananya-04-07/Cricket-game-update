package com.cricketGame;

import java.util.Random;

public class GetRandom {
    private final static Random rand = new Random();
    public static int getRandomNumber(int range)
    {
        int t1 = rand.nextInt(range);
        return t1;
    }
}
