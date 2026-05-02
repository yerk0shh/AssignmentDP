package com.narxoz.rpg.artifact.visitor;

import com.narxoz.rpg.artifact.*;

public class EnchantmentScanner implements ArtifactVisitor {
    @Override
    public void visit(Weapon weapon) {
        System.out.println("Enchantment scanner: " + weapon.getName() + " hums with battle magic, power " + weapon.getMagicPower());
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("Enchantment scanner: " + potion.getName() + " carries restorative aura, healing " + potion.getHealing());
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("Enchantment scanner: " + scroll.getName() + " contains spell: " + scroll.getSpell());
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("Enchantment scanner: " + ring.getName() + " grants bonus: " + ring.getBonus());
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("Enchantment scanner: " + armor.getName() + " is shielded with defense aura " + armor.getDefense());
    }
}
