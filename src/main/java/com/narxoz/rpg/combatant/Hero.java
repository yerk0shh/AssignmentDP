package com.narxoz.rpg.combatant;

import com.narxoz.rpg.strategy.CombatStrategy;

public class Hero {

    private String name;
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;

    private CombatStrategy strategy;

    public Hero(String name, int hp, int attack, int defense, CombatStrategy strategy) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
        this.defense = defense;
        this.strategy = strategy;
    }

    public int attack() {
        return strategy.calculateDamage(attack);
    }

    public void takeDamage(int damage) {
        int finalDamage = Math.max(0, damage - strategy.calculateDefense(defense));
        hp -= finalDamage;

        if (hp < 0) hp = 0;
    }

    public void setStrategy(CombatStrategy strategy) {
        this.strategy = strategy;
        System.out.println(name + " switched to " + strategy.getName());
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public CombatStrategy getStrategy() {
        return strategy;
    }
}