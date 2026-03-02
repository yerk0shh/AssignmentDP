package com.narxoz.rpg.enemy;

public class Phase {

    private final int phaseNumber;
    private final int healthThreshold;

    public Phase(int phaseNumber, int healthThreshold) {
        this.phaseNumber = phaseNumber;
        this.healthThreshold = healthThreshold;
    }

    public int getPhaseNumber() {
        return phaseNumber;
    }

    public int getHealthThreshold() {
        return healthThreshold;
    }
}