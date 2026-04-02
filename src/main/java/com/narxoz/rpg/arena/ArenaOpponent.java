package com.narxoz.rpg.arena;

public class ArenaOpponent {
    private int hp;
    private int attackPower;

    public ArenaOpponent(int hp, int attackPower) {
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public void takeDamage(int damage) {
        hp = Math.max(0, hp - damage);
    }

    public void heal(int amount) {
        hp += amount;
    }

    public int getHp() { return hp; }
    public int getAttackPower() { return attackPower; }

    public boolean isAlive() {
        return hp > 0;
    }
}