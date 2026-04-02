package com.narxoz.rpg.tournament;

/**
 * TournamentEngine coordinates a multi-round battle between a hero and an opponent.
 *
 * It integrates:
 * - Command Pattern: for queuing and executing hero actions
 * - Chain of Responsibility: for processing incoming damage
 */

import com.narxoz.rpg.chain.*;
import com.narxoz.rpg.command.*;
import com.narxoz.rpg.arena.*;

import java.util.*;

public class TournamentEngine {

    /**
     * Runs the tournament until one fighter dies or max rounds reached.
     *
     * @param hero the player-controlled fighter
     * @param opponent the enemy fighter
     * @return TournamentResult containing winner, rounds, and battle log
     */

    public TournamentResult runTournament(ArenaFighter hero, ArenaOpponent opponent) {

        List<String> log = new ArrayList<>();
        ActionQueue queue = new ActionQueue();
        DefenseHandler chain = buildDefenseChain(hero);

        int rounds = 0;
        int maxRounds = 50;

        while (hero.isAlive() && opponent.isAlive() && rounds < maxRounds) {
            rounds++;
            log.add("Round " + rounds);

            if (hero.getHp() < 50) {
                queue.enqueue(new HealCommand(hero, 10));
                log.add("Hero decides to heal");
            } else {
                queue.enqueue(new AttackCommand(opponent, hero.getAttackPower()));
                log.add("Hero attacks");
            }

            queue.enqueue(new DefendCommand(hero, 0.1));
            log.add("Hero prepares defense");

            // --- выполнение ---
            queue.executeAll();

            log.add("Enemy HP: " + opponent.getHp());

            // --- атака врага ---
            if (opponent.isAlive()) {
                log.add("Enemy attacks for " + opponent.getAttackPower());

                int before = hero.getHp();
                chain.handle(opponent.getAttackPower(), hero);
                int after = hero.getHp();

                if (before == after) {
                    log.add("Hero dodged the attack!");
                } else {
                    log.add("Hero HP: " + after);
                }
            }
        }

        String winner = hero.isAlive() ? "Hero" : "Opponent";
        return new TournamentResult(winner, rounds, log);
    }

    /**
     * Builds the defense chain in order:
     * Dodge → Block → Armor → HP
     *
     * Each handler modifies or stops the incoming damage.
     */

    private DefenseHandler buildDefenseChain(ArenaFighter hero) {
        DefenseHandler chain = new DodgeHandler(hero.getDodgeChance());
        chain.setNext(new BlockHandler(hero.getBlockRating() / 100.0))
                .setNext(new ArmorHandler(hero.getArmor()))
                .setNext(new HpHandler());
        return chain;
    }
}