package com.narxoz.rpg.engine;

import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.observer.*;

import java.util.List;

public class DungeonEngine {

    public EncounterResult run(List<Hero> heroes, DungeonBoss boss, EventManager manager) {

        int round = 1;
        int maxRounds = 20;

        while (boss.isAlive() && heroes.stream().anyMatch(Hero::isAlive)) {

            System.out.println("\n=== ROUND " + round + " ===");

            // 🔹 Герои атакуют
            for (Hero hero : heroes) {
                if (!hero.isAlive()) continue;

                int damage = hero.attack();

                boss.takeDamage(damage, manager);

                manager.notify(new GameEvent(
                        GameEventType.ATTACK_LANDED,
                        hero.getName(),
                        damage
                ));
            }

            // 🔹 Босс атакует
            for (Hero hero : heroes) {
                if (!hero.isAlive()) continue;

                int damage = boss.attack();

                hero.takeDamage(damage);

                // события героя
                if (hero.getHp() <= 0) {
                    manager.notify(new GameEvent(
                            GameEventType.HERO_DIED,
                            hero.getName(),
                            0
                    ));
                } else if (hero.getHp() < hero.getMaxHp() * 0.3) {
                    manager.notify(new GameEvent(
                            GameEventType.HERO_LOW_HP,
                            hero.getName(),
                            hero.getHp()
                    ));
                }
            }

            round++;
            if (round > maxRounds) break;
        }

        // 🔹 результат
        boolean bossDefeated = !boss.isAlive();
        return new EncounterResult(bossDefeated, round);
    }
}