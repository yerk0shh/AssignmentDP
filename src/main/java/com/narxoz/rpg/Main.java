package com.narxoz.rpg;

import com.narxoz.rpg.arena.*;
import com.narxoz.rpg.command.*;
import com.narxoz.rpg.chain.*;
import com.narxoz.rpg.tournament.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== COMMAND DEMO ===");

        ArenaFighter hero = new ArenaFighter(100, 20, 0.2, 30, 5);
        ArenaOpponent enemy = new ArenaOpponent(80, 15);

        ActionQueue queue = new ActionQueue();

        queue.enqueue(new AttackCommand(enemy, hero.getAttackPower()));
        queue.enqueue(new HealCommand(hero, 15));
        queue.enqueue(new DefendCommand(hero, 0.2));

        System.out.println("Queue before undo:");
        System.out.println(queue.getCommandDescriptions());

        queue.undoLast();

        System.out.println("Queue after undo:");
        System.out.println(queue.getCommandDescriptions());

        System.out.println("Executing commands...");
        queue.executeAll();

        System.out.println("\n=== CHAIN OF RESPONSIBILITY DEMO ===");

        System.out.println("Hero HP before attack: " + hero.getHp());

        DefenseHandler chain = new DodgeHandler(hero.getDodgeChance());
        chain.setNext(new BlockHandler(hero.getBlockRating() / 100.0))
                .setNext(new ArmorHandler(hero.getArmor()))
                .setNext(new HpHandler());

        int incomingDamage = 50;
        System.out.println("Incoming damage: " + incomingDamage);

        chain.handle(incomingDamage, hero);

        System.out.println("Hero HP after defense: " + hero.getHp());

        System.out.println("\n=== TOURNAMENT DEMO ===");

        // New HERO and ENEMY
        ArenaFighter tournamentHero = new ArenaFighter(100, 20, 0.2, 30, 5);
        ArenaOpponent tournamentEnemy = new ArenaOpponent(80, 15);

        TournamentEngine engine = new TournamentEngine();
        TournamentResult result = engine.runTournament(tournamentHero, tournamentEnemy);

        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());

        System.out.println("=== LOG ===");
        for (String log : result.getLog()) {
            System.out.println(log);
        }

    }
}