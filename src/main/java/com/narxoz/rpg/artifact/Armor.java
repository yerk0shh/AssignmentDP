package com.narxoz.rpg.artifact;

public class Armor extends Artifact {
    private final int defense;

    public Armor(String name, int magicPower, int baseValue, double weight, int defense) {
        super(name, magicPower, baseValue, weight);
        this.defense = defense;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }

    public int getDefense() {
        return defense;
    }
}
