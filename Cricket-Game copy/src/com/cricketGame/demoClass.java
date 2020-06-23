package com.cricketGame;
import java.util.*;

public class demoClass {
    private String team;
    private int run;

    public String getTeam() {
        return team;
    }

    public int getRun() {
        return run;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public static void main(String[] args) {
        Map<String,demoClass> mp = new HashMap<>();
        demoClass dm = new demoClass();
        dm.setTeam("India");
        dm.setRun(20);


        mp.put("dhoni",dm);
        System.out.println(mp.get("dhoni").team);
        demoClass dt = mp.get("dhoni");
        dt.setRun(40);
        System.out.println(mp.get("dhoni").getRun());

    }
}
