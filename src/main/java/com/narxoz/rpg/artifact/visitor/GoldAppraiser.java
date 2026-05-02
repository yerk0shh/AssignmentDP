package com.narxoz.rpg.artifact.visitor;

import com.narxoz.rpg.artifact.*;

public class GoldAppraiser implements ArtifactVisitor {
    private int totalValue;

    @Override
    public void visit(Weapon weapon) {
        int value = weapon.getBaseValue() + weapon.getDamage() * 5 + weapon.getMagicPower() * 3;
        totalValue += value;
        System.out.println("Gold appraiser: " + weapon.getName() + " weapon value = " + value);
    }

    @Override
    public void visit(Potion potion) {
        int value = potion.getBaseValue() + potion.getHealing() * 2;
        totalValue += value;
        System.out.println("Gold appraiser: " + potion.getName() + " potion value = " + value);
    }

    @Override
    public void visit(Scroll scroll) {
        int value = scroll.getBaseValue() + scroll.getMagicPower() * 6;
        totalValue += value;
        System.out.println("Gold appraiser: " + scroll.getName() + " scroll value = " + value);
    }

    @Override
    public void visit(Ring ring) {
        int value = ring.getBaseValue() + ring.getMagicPower() * 8;
        totalValue += value;
        System.out.println("Gold appraiser: " + ring.getName() + " ring value = " + value);
    }

    @Override
    public void visit(Armor armor) {
        int value = armor.getBaseValue() + armor.getDefense() * 4;
        totalValue += value;
        System.out.println("Gold appraiser: " + armor.getName() + " armor value = " + value);
    }

    public int getTotalValue() {
        return totalValue;
    }
}
