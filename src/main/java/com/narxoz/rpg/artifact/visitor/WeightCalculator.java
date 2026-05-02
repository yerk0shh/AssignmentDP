package com.narxoz.rpg.artifact.visitor;

import com.narxoz.rpg.artifact.*;

public class WeightCalculator implements ArtifactVisitor {
    private double totalWeight;

    @Override
    public void visit(Weapon weapon) {
        add(weapon, "weapon load");
    }

    @Override
    public void visit(Potion potion) {
        add(potion, "liquid load");
    }

    @Override
    public void visit(Scroll scroll) {
        add(scroll, "paper load");
    }

    @Override
    public void visit(Ring ring) {
        add(ring, "jewelry load");
    }

    @Override
    public void visit(Armor armor) {
        add(armor, "armor load");
    }

    private void add(Artifact artifact, String label) {
        totalWeight += artifact.getWeight();
        System.out.println("Weight calculator: " + artifact.getName() + " " + label + " = " + artifact.getWeight());
    }

    public double getTotalWeight() {
        return totalWeight;
    }
}
