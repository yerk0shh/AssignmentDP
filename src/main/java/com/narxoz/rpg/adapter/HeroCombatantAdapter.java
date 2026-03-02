package com.narxoz.rpg.adapter;

import com.narxoz.rpg.characters.GameCharacter;

public class HeroCombatantAdapter implements Combatant {

    private GameCharacter hero;
    private int health = 100;

    public HeroCombatantAdapter(GameCharacter hero) {
        this.hero = hero;
    }

    @Override
    public String getName() {
        return hero.getClass().getSimpleName();
    }

    @Override
    public int getAttackPower() {
        return 15;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;

        System.out.println(
                getName() +
                        " takes " + damage +
                        " damage. HP=" + health);
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}