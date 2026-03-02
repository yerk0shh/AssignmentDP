package com.narxoz.rpg.ability;

public class ShadowStrike implements Ability {

    private final String name = "Shadow Strike";
    private final int damage = 200;
    private final String description = "High single-target shadow attack.";

    @Override
    public String getName() { return name; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public String getDescription() { return description; }

    @Override
    public Ability clone() {
        return new ShadowStrike();
    }
}