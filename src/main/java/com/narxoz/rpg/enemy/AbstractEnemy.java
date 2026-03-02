package com.narxoz.rpg.enemy;

import com.narxoz.rpg.ability.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.*;

public abstract class AbstractEnemy implements Enemy {

    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected String element;

    protected List<Ability> abilities = new ArrayList<>();
    protected LootTable lootTable;
    protected String aiBehavior;

    protected Map<Integer, Integer> phases = new HashMap<>();

    @Override
    public String getName() { return name; }

    @Override
    public int getHealth() { return health; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public int getDefense() { return defense; }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public String getElement() { return element; }

    @Override
    public List<Ability> getAbilities() {
        return new ArrayList<>(abilities);
    }

    @Override
    public LootTable getLootTable() { return lootTable; }

    @Override
    public String getAIBehavior() { return aiBehavior; }

    @Override
    public Map<Integer, Integer> getPhases() {
        return new HashMap<>(phases);
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public void setAIBehavior(String aiBehavior) {
        this.aiBehavior = aiBehavior;
    }

    @Override
    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }

    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = new ArrayList<>(abilities);
    }

    public void addPhase(int phaseNumber, int threshold) {
        this.phases.put(phaseNumber, threshold);
    }

    @Override
    public abstract Enemy clone();
}