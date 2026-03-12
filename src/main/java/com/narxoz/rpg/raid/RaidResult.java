package com.narxoz.rpg.raid;

import java.util.ArrayList;
import java.util.List;

public class RaidResult {

    private String winner;
    private int rounds;
    private List<String> log = new ArrayList<>();

    public void setWinner(String winner){
        this.winner = winner;
    }

    public void setRounds(int rounds){
        this.rounds = rounds;
    }

    public void addLog(String message){
        log.add(message);
    }

    public String getWinner(){
        return winner;
    }

    public int getRounds(){
        return rounds;
    }

    public void printLog(){
        for(String line : log){
            System.out.println(line);
        }
    }
}