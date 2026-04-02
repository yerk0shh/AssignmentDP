package com.narxoz.rpg.arena;

public class ArenaFighter {
    private int hp;
    private int maxHp;
    private int attackPower;

    private double dodgeChance;
    private int blockRating;
    private int armor;

    public ArenaFighter(int hp, int attackPower, double dodgeChance, int blockRating, int armor) {
        this.hp = hp;
        this.maxHp = hp;
        this.attackPower = attackPower;
        this.dodgeChance = dodgeChance;
        this.blockRating = blockRating;
        this.armor = armor;
    }

    // --- БОЙ ---
    public void takeDamage(int damage) {
        hp = Math.max(0, hp - damage);
        System.out.println("Hero takes " + damage + " damage. HP: " + hp);
    }

    public int heal(int amount) {
        int before = hp;
        hp = Math.min(maxHp, hp + amount);
        int healed = hp - before;

        System.out.println("Hero heals " + healed + ". HP: " + hp);
        return healed;
    }

    // --- DEFENSE ---
    public void increaseDodge(double boost) {
        dodgeChance += boost;
    }

    public void decreaseDodge(double boost) {
        dodgeChance -= boost;
    }

    // --- GETTERS ---
    public int getHp() { return hp; }
    public int getAttackPower() { return attackPower; }
    public double getDodgeChance() { return dodgeChance; }
    public int getBlockRating() { return blockRating; }
    public int getArmor() { return armor; }

    public boolean isAlive() {
        return hp > 0;
    }
}