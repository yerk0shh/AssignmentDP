package com.narxoz.rpg.characters;

public class Mage extends BaseCharacter {

    public Mage() {
        name = "Mage";
        health = 70;
        mana = 150;
        strength = 5;
        intelligence = 25;
    }

    @Override
    public void useSpecialAbility() {
        System.out.println("Fireball! Massive magic damage 🔥");
    }
}
