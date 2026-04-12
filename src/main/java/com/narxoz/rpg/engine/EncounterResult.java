package com.narxoz.rpg.engine;

public class EncounterResult {

    private boolean bossDefeated;
    private int rounds;

    public EncounterResult(boolean bossDefeated, int rounds) {
        this.bossDefeated = bossDefeated;
        this.rounds = rounds;
    }

    public boolean isBossDefeated() {
        return bossDefeated;
    }

    public int getRounds() {
        return rounds;
    }
}