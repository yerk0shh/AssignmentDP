package com.narxoz.rpg;

import com.narxoz.rpg.arena.*;
import com.narxoz.rpg.command.*;
import com.narxoz.rpg.chain.*;
import com.narxoz.rpg.tournament.*;

public class Main {

    public static void main(String[] args) {

        // === COMMAND DEMO ===
        System.out.println("=== COMMAND DEMO ===");

        ArenaFighter hero = new ArenaFighter(100, 20, 0.2, 30, 5);
        ArenaOpponent enemy = new ArenaOpponent(80, 15);

        ActionQueue queue = new ActionQueue();

        queue.enqueue(new AttackCommand(enemy, hero.getAttackPower()));
        queue.enqueue(new HealCommand(hero, 15));
        queue.enqueue(new DefendCommand(hero, 0.2));

        System.out.println("Before undo: " + queue.getCommandDescriptions());

        queue.undoLast();

        System.out.println("After undo: " + queue.getCommandDescriptions());

        queue.executeAll();

        // === CHAIN DEMO ===
        System.out.println("\n=== CHAIN DEMO ===");

        DefenseHandler chain = new DodgeHandler(hero.getDodgeChance());
        chain.setNext(new BlockHandler(hero.getBlockRating() / 100.0))
                .setNext(new ArmorHandler(hero.getArmor()))
                .setNext(new HpHandler());

        System.out.println("HP before: " + hero.getHp());
        chain.handle(50, hero);
        System.out.println("HP after: " + hero.getHp());

        // === TOURNAMENT ===
        System.out.println("\n=== TOURNAMENT ===");

        ArenaFighter tHero = new ArenaFighter(100, 20, 0.2, 30, 5);
        ArenaOpponent tEnemy = new ArenaOpponent(80, 15);

        TournamentEngine engine = new TournamentEngine();
        TournamentResult result = engine.runTournament(tHero, tEnemy);

        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());

        System.out.println("--- LOG ---");
        for (String s : result.getLog()) {
            System.out.println(s);
        }
    }
}