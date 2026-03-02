package com.narxoz.rpg.ability;

public class FlameBreath implements Ability {

    private final String name;
    private final int damage;
    private final String description;

    public FlameBreath() {
        this.name = "Flame Breath";
        this.damage = 150;
        this.description = "Breathes fire in a cone, burning enemies.";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Ability clone() {
        return new FlameBreath();
    }
}