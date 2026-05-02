package com.narxoz.rpg.vault;

public class VaultRunResult {
    private final int heroes;
    private final int artifacts;
    private final int totalGoldValue;
    private final int cursedArtifacts;
    private final double totalWeight;

    public VaultRunResult(int heroes, int artifacts, int totalGoldValue, int cursedArtifacts, double totalWeight) {
        this.heroes = heroes;
        this.artifacts = artifacts;
        this.totalGoldValue = totalGoldValue;
        this.cursedArtifacts = cursedArtifacts;
        this.totalWeight = totalWeight;
    }

    @Override
    public String toString() {
        return "VaultRunResult{" +
                "heroes=" + heroes +
                ", artifacts=" + artifacts +
                ", totalGoldValue=" + totalGoldValue +
                ", cursedArtifacts=" + cursedArtifacts +
                ", totalWeight=" + totalWeight +
                '}';
    }
}
