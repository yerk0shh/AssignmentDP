package com.narxoz.rpg.composite;

import com.narxoz.rpg.characters.GameCharacter;

public class HeroUnit implements CombatNode {

    private GameCharacter hero;

    public HeroUnit(GameCharacter hero){
        this.hero = hero;
    }

    @Override
    public int getAttackPower() {
        return hero.getAttack();
    }

    @Override
    public void takeDamage(int amount) {
        hero.takeDamage(amount);
    }

    @Override
    public boolean isAlive() {
        return hero.isAlive();
    }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + "Hero: " + hero.getName());
    }
}