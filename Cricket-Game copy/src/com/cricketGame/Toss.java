package com.cricketGame;
import java.util.Random;


public class Toss {

    public static String tossDecision(String Team1,String Team2)
    {

        int rand_no = GetRandom.getRandomNumber(2);
        if (rand_no == 0)
            return Team1;
        else
            return Team2;
    }
    public static String tossForBatBall(String Team)
    {
        Random rand = new Random();
        int rand_no = rand.nextInt(2);
        //if (rand_no == 0)
            return "Batting";
        //else
            //return "Bowling";
    }
}
