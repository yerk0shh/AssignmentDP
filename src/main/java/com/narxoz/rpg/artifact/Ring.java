package com.narxoz.rpg.artifact;

public class Ring extends Artifact {
    private final String bonus;

    public Ring(String name, int magicPower, int baseValue, double weight, String bonus) {
        super(name, magicPower, baseValue, weight);
        this.bonus = bonus;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }

    public String getBonus() {
        return bonus;
    }
}
