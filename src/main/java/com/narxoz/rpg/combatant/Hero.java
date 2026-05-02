package com.narxoz.rpg.combatant;

import com.narxoz.rpg.artifact.Artifact;
import com.narxoz.rpg.strategy.CombatStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hero {
    private String name;
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private int mana;
    private int gold;
    private final List<Artifact> inventory = new ArrayList<>();
    private CombatStrategy strategy;

    public Hero(String name, int hp, int attack, int defense, CombatStrategy strategy) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
        this.defense = defense;
        this.strategy = strategy;
    }

    public Hero(String name, int hp, int mana, int gold) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.mana = mana;
        this.gold = gold;
    }

    public int attack() {
        if (strategy == null) {
            return attack;
        }
        return strategy.calculateDamage(attack);
    }

    public void takeDamage(int damage) {
        int finalDamage = damage;
        if (strategy != null) {
            finalDamage = Math.max(0, damage - strategy.calculateDefense(defense));
        }
        hp = Math.max(0, hp - finalDamage);
    }

    public void spendMana(int amount) {
        mana = Math.max(0, mana - amount);
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public void spendGold(int amount) {
        gold = Math.max(0, gold - amount);
    }

    public void addArtifact(Artifact artifact) {
        inventory.add(artifact);
    }

    public HeroMemento createMemento() {
        return new HeroMemento(hp, mana, gold, inventory);
    }

    public void restoreFromMemento(HeroMemento memento) {
        hp = memento.getHp();
        mana = memento.getMana();
        gold = memento.getGold();
        inventory.clear();
        inventory.addAll(memento.getInventory());
    }

    public String describeState() {
        return name + " [hp=" + hp + ", mana=" + mana + ", gold=" + gold + ", inventory=" + inventory.size() + "]";
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

    public int getMana() {
        return mana;
    }

    public int getGold() {
        return gold;
    }

    public List<Artifact> getInventory() {
        return Collections.unmodifiableList(inventory);
    }

    public CombatStrategy getStrategy() {
        return strategy;
    }
}
