package com.narxoz.rpg.artifact;

public abstract class Artifact {
    private final String name;
    private final int magicPower;
    private final int baseValue;
    private final double weight;

    protected Artifact(String name, int magicPower, int baseValue, double weight) {
        this.name = name;
        this.magicPower = magicPower;
        this.baseValue = baseValue;
        this.weight = weight;
    }

    public abstract void accept(ArtifactVisitor visitor);

    public String getName() {
        return name;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public double getWeight() {
        return weight;
    }
}
