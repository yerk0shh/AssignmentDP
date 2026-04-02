package com.narxoz.rpg.arena;

import java.util.List;

public class TournamentResult {
    private String winner;
    private int rounds;
    private List<String> log;

    public TournamentResult(String winner, int rounds, List<String> log) {
        this.winner = winner;
        this.rounds = rounds;
        this.log = log;
    }

    public String getWinner() {
        return winner;
    }

    public int getRounds() {
        return rounds;
    }

    public List<String> getLog() {
        return log;
    }
}