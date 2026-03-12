package com.narxoz.rpg.characters;

import com.narxoz.rpg.equipment.EquipmentFactory;

public interface GameCharacter {

    void getStats();

    void useSpecialAbility();

    void equip(EquipmentFactory factory);

    // --- методы для боевой системы ---
    String getName();

    int getAttack();

    void takeDamage(int damage);

    boolean isAlive();
}