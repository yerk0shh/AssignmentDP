package com.narxoz.rpg.ability;

public class FrostBreath implements Ability {

    private final String name = "Frost Breath";
    private final int damage = 120;
    private final String description = "Breathes icy wind, slowing enemies.";

    @Override
    public String getName() { return name; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public String getDescription() { return description; }

    @Override
    public Ability clone() {
        return new FrostBreath();
    }
}