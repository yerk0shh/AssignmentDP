package com.narxoz.rpg.characters;

public class Archer extends BaseCharacter {

    public Archer() {
        name = "Archer";
        health = 100;
        mana = 60;
        strength = 15;
        intelligence = 10;
    }

    @Override
    public void useSpecialAbility() {
        System.out.println("Arrow Rain! Hits multiple enemies 🎯");
    }
}

