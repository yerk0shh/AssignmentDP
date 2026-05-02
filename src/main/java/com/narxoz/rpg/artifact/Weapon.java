package com.narxoz.rpg.artifact;

public class Weapon extends Artifact {
    private final int damage;

    public Weapon(String name, int magicPower, int baseValue, double weight, int damage) {
        super(name, magicPower, baseValue, weight);
        this.damage = damage;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }

    public int getDamage() {
        return damage;
    }
}
