package com.cricketGame;

public class PlayerOld {
    enum The_Sons_of_Pitches{rahul_dravid,m_s_dhoni,virat_kohli;}
    enum Bloodbath_and_Beyond{Glenn_Maxwell,Mitchell_arsh,Ashton_Agar;}
    enum The_Master_Batter{Kamindu_Mendis,Priyamal_Perera,Minod_Bhanuka}
    enum Ball_Busters{}
    public static String[] playerName(String Team1 ,String Team2)
    {
        int size = (The_Sons_of_Pitches.values().length + Bloodbath_and_Beyond.values().length);
        String [] playername = new String[size];
        for(int i = 0 ; i<size;i++)
        {
            if(i<The_Sons_of_Pitches.values().length) {
                playername[i] = The_Sons_of_Pitches.values()[i].name();
            }
            else {
                playername[i] = Bloodbath_and_Beyond.values()[i-Bloodbath_and_Beyond.values().length].name();
            }
        }
        return playername;
    }
}
