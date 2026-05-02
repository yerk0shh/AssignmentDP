package com.narxoz.rpg.artifact;

public class Potion extends Artifact {
    private final int healing;

    public Potion(String name, int magicPower, int baseValue, double weight, int healing) {
        super(name, magicPower, baseValue, weight);
        this.healing = healing;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }

    public int getHealing() {
        return healing;
    }
}
