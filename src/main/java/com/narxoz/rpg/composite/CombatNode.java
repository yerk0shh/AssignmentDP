package com.narxoz.rpg.composite;

public interface CombatNode {

    int getAttackPower();

    void takeDamage(int amount);

    boolean isAlive();

    void printTree(String indent);
}