package com.narxoz.rpg.tournament;

import com.narxoz.rpg.chain.*;
import com.narxoz.rpg.command.*;
import com.narxoz.rpg.arena.*;

import java.util.*;

public class TournamentEngine {

    public TournamentResult runTournament(ArenaFighter hero, ArenaOpponent opponent) {

        List<String> log = new ArrayList<>();

        DefenseHandler chain = new DodgeHandler(hero.getDodgeChance());
        chain.setNext(new BlockHandler(hero.getBlockRating() / 100.0))
                .setNext(new ArmorHandler(hero.getArmor()))
                .setNext(new HpHandler());
        
        int rounds = 0;
        int maxRounds = 50;

        while (hero.isAlive() && opponent.isAlive() && rounds < maxRounds) {
            rounds++;
            log.add("Round " + rounds);

            ActionQueue queue = new ActionQueue();

            queue.enqueue(new AttackCommand(opponent, hero.getAttackPower()));
            queue.enqueue(new HealCommand(hero, 10));

            log.add("Hero executes actions");

            queue.executeAll();

            log.add("Enemy HP: " + opponent.getHp());

            if (opponent.isAlive()) {
                chain.handle(opponent.getAttackPower(), hero);
                log.add("Hero HP after attack: " + hero.getHp());

            }
        }

        String winner = hero.isAlive() ? "Hero" : "Opponent";

        return new TournamentResult(winner, rounds, log);
    }
}