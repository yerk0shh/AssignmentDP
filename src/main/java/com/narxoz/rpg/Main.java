package com.narxoz.rpg;

import com.narxoz.rpg.engine.EncounterResult;
import com.narxoz.rpg.strategy.*;
import com.narxoz.rpg.observer.*;
import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.engine.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Event system
        EventManager manager = new EventManager();

        manager.subscribe(new BattleLogger());
        manager.subscribe(new AchievementTracker());
        manager.subscribe(new PartySupport());
        manager.subscribe(new HeroStatusMonitor());
        manager.subscribe(new LootDropper());

        // Boss
        DungeonBoss boss = new DungeonBoss(500, 50, 20);
        manager.subscribe(boss);

        // Heroes
        Hero knight = new Hero("Knight", 200, 40, 25, new DefensiveStrategy());
        Hero archer = new Hero("Archer", 150, 50, 10, new AggressiveStrategy());
        Hero mage = new Hero("Mage", 130, 60, 8, new BalancedStrategy());

        List<Hero> heroes = Arrays.asList(knight, archer, mage);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                archer.setStrategy(new DefensiveStrategy());
            }
        }, 3000);

        // Запуск боя
        DungeonEngine engine = new DungeonEngine();
        EncounterResult result = engine.run(heroes, boss, manager);

        // Итог
        System.out.println("\n=== RESULT ===");
        System.out.println("Boss defeated: " + result.isBossDefeated());
        System.out.println("Rounds: " + result.getRounds());
    }
}