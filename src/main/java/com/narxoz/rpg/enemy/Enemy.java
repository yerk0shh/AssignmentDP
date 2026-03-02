package com.narxoz.rpg.enemy;

import com.narxoz.rpg.ability.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.Map;

public interface Enemy extends Cloneable {

    String getName();
    int getHealth();
    int getDamage();
    int getDefense();
    int getSpeed();
    String getElement();

    void setName(String name);
    void setHealth(int health);
    void setDamage(int damage);
    void setDefense(int defense);
    void setSpeed(int speed);
    void setElement(String element);

    void setAIBehavior(String aiBehavior);
    void setLootTable(LootTable lootTable);

    void addAbility(Ability ability);
    void setAbilities(List<Ability> abilities);
    void addPhase(int phaseNumber, int healthThreshold);

    List<Ability> getAbilities();
    LootTable getLootTable();
    String getAIBehavior();
    Map<Integer, Integer> getPhases();

    Enemy clone();
}