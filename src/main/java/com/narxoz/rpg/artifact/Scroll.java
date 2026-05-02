package com.narxoz.rpg.artifact;

public class Scroll extends Artifact {
    private final String spell;

    public Scroll(String name, int magicPower, int baseValue, double weight, String spell) {
        super(name, magicPower, baseValue, weight);
        this.spell = spell;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }

    public String getSpell() {
        return spell;
    }
}
