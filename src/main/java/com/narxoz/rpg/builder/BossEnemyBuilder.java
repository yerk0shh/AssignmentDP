package com.narxoz.rpg.builder;

import com.narxoz.rpg.ability.Ability;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class BossEnemyBuilder implements EnemyBuilder {

    private final BossEnemy enemy;

    public BossEnemyBuilder() {
        this.enemy = new BossEnemy();
    }

    @Override
    public EnemyBuilder setName(String name) {
        enemy.setName(name);
        return this;
    }

    @Override
    public EnemyBuilder setHealth(int health) {
        enemy.setHealth(health);
        return this;
    }

    @Override
    public EnemyBuilder setDamage(int damage) {
        enemy.setDamage(damage);
        return this;
    }

    @Override
    public EnemyBuilder setDefense(int defense) {
        enemy.setDefense(defense);
        return this;
    }

    @Override
    public EnemyBuilder setSpeed(int speed) {
        enemy.setSpeed(speed);
        return this;
    }

    @Override
    public EnemyBuilder setElement(String element) {
        enemy.setElement(element);
        return this;
    }

    @Override
    public EnemyBuilder addAbility(Ability ability) {
        enemy.addAbility(ability);
        return this;
    }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        enemy.setAbilities(abilities);
        return this;
    }

    @Override
    public EnemyBuilder setLootTable(LootTable lootTable) {
        enemy.setLootTable(lootTable);
        return this;
    }

    @Override
    public EnemyBuilder setAIBehavior(String aiBehavior) {
        enemy.setAIBehavior(aiBehavior);
        return this;
    }

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        enemy.addPhase(phaseNumber, healthThreshold);
        return this;
    }

    @Override
    public Enemy build() {

        if (enemy.getName() == null || enemy.getName().isEmpty())
            throw new IllegalStateException("Boss must have a name!");

        if (enemy.getHealth() <= 0)
            throw new IllegalStateException("Boss must have positive health!");

        if (enemy.getAbilities().isEmpty())
            throw new IllegalStateException("Boss must have at least one ability!");
        return enemy;
    }
}