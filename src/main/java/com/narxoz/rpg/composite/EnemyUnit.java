package com.narxoz.rpg.composite;

import com.narxoz.rpg.characters.GameCharacter;

public class EnemyUnit implements CombatNode {

    private GameCharacter enemy;

    public EnemyUnit(GameCharacter enemy){
        this.enemy = enemy;
    }

    @Override
    public int getAttackPower() {
        return enemy.getAttack();
    }

    @Override
    public void takeDamage(int amount) {
        enemy.takeDamage(amount);
    }

    @Override
    public boolean isAlive() {
        return enemy.isAlive();
    }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + "Enemy: " + enemy.getName());
    }
}