package com.narxoz.rpg.battle;

public class EncounterResult {

    private String winner;
    private int rounds;

    public EncounterResult(String winner, int rounds) {
        this.winner = winner;
        this.rounds = rounds;
    }

    public String getWinner() {
        return winner;
    }

    public int getRounds() {
        return rounds;
    }

    @Override
    public String toString() {
        return "Winner: " + winner +
                ", Rounds: " + rounds;
    }
}