package com.narxoz.rpg.characters;

public class Warrior extends BaseCharacter {

    public Warrior() {
        name = "Warrior";
        health = 150;
        mana = 30;
        strength = 20;
        intelligence = 5;
    }

    @Override
    public void useSpecialAbility() {
        System.out.println("Power Strike! Huge physical damage 💥");
    }
}
