package com.narxoz.rpg.adapter;

import com.narxoz.rpg.enemy.Enemy;

public class EnemyCombatantAdapter implements Combatant {

    private Enemy enemy;
    private int health;

    public EnemyCombatantAdapter(Enemy enemy) {
        this.enemy = enemy;
        this.health = enemy.getHealth();
    }

    @Override
    public String getName() {
        return enemy.getName();
    }

    @Override
    public int getAttackPower() {
        return enemy.getDamage();
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;

        System.out.println(
                enemy.getName()
                        + " takes "
                        + damage
                        + " damage. HP=" + health);
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}