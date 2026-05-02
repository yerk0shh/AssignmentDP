package com.narxoz.rpg.artifact.visitor;

import com.narxoz.rpg.artifact.*;

public class CurseDetector implements ArtifactVisitor {
    private int cursedCount;

    @Override
    public void visit(Weapon weapon) {
        check(weapon.getName(), weapon.getMagicPower() > 25, "blood-bound blade");
    }

    @Override
    public void visit(Potion potion) {
        check(potion.getName(), potion.getHealing() < 20, "unstable brew");
    }

    @Override
    public void visit(Scroll scroll) {
        check(scroll.getName(), scroll.getSpell().toLowerCase().contains("shadow"), "shadow writing");
    }

    @Override
    public void visit(Ring ring) {
        check(ring.getName(), ring.getBonus().toLowerCase().contains("greed"), "greed curse");
    }

    @Override
    public void visit(Armor armor) {
        check(armor.getName(), armor.getWeight() > 15, "anchor curse");
    }

    private void check(String name, boolean cursed, String reason) {
        if (cursed) {
            cursedCount++;
            System.out.println("Curse detector: " + name + " is dangerous: " + reason);
        } else {
            System.out.println("Curse detector: " + name + " is clean");
        }
    }

    public int getCursedCount() {
        return cursedCount;
    }
}
