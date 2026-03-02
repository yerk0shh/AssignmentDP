package com.narxoz.rpg.ability;

public class IceShield implements Ability {

    private final String name = "Ice Shield";
    private final int damage = 0;
    private final String description = "Creates a defensive ice barrier.";

    @Override
    public String getName() { return name; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public String getDescription() { return description; }

    @Override
    public Ability clone() {
        return new IceShield();
    }
}