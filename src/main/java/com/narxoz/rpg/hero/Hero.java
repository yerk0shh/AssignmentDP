package com.narxoz.rpg.hero;

import com.narxoz.rpg.decorator.AttackAction;

public class Hero {

    private String name;
    private int hp;
    private AttackAction attack;

    public Hero(String name, int hp, AttackAction attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public int attack() {
        return attack.execute();
    }

    public AttackAction getAttack() {
        return attack;
    }
}
