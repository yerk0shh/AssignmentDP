package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {

    public Enemy createMinion(EnemyBuilder builder, EnemyComponentFactory factory) {
        return builder
                .setName("Minion")
                .setHealth(100)
                .setDamage(20)
                .setDefense(10)
                .setSpeed(30)
                .setElement("BASIC")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAIBehavior(factory.createAIBehavior())
                .build();
    }

    public Enemy createRaidBoss(EnemyBuilder builder, EnemyComponentFactory factory) {
        return builder
                .setName("Raid Boss")
                .setHealth(5000)
                .setDamage(300)
                .setDefense(200)
                .setSpeed(50)
                .setElement("BOSS")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAIBehavior(factory.createAIBehavior())
                .addPhase(1, 70)
                .addPhase(2, 40)
                .addPhase(3, 10)
                .build();
    }
}