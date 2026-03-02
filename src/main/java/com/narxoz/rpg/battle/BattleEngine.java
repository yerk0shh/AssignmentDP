package com.narxoz.rpg.battle;

import com.narxoz.rpg.adapter.Combatant;

import java.util.*;

public class BattleEngine {

    private static BattleEngine instance;
    private Random random = new Random();

    private BattleEngine() {}

    public static BattleEngine getInstance() {
        if (instance == null) {
            instance = new BattleEngine();
        }
        return instance;
    }

    public BattleEngine setRandomSeed(long seed) {
        random.setSeed(seed);
        return this;
    }

    public void reset() {
        random = new Random();
    }

    public EncounterResult runEncounter(
            List<Combatant> teamA,
            List<Combatant> teamB) {

        int round = 1;

        while (!teamA.isEmpty() && !teamB.isEmpty()) {

            System.out.println("\n=== ROUND " + round + " ===");

            attackPhase(teamA, teamB);
            attackPhase(teamB, teamA);

            teamA.removeIf(c -> !c.isAlive());
            teamB.removeIf(c -> !c.isAlive());

            round++;
        }

        String winner =
                teamA.isEmpty()
                        ? "Team B"
                        : "Team A";

        return new EncounterResult(winner, round - 1);
    }

    private void attackPhase(
            List<Combatant> attackers,
            List<Combatant> defenders) {

        for (Combatant attacker : attackers) {

            if (defenders.isEmpty()) return;

            Combatant target =
                    defenders.get(random.nextInt(defenders.size()));

            int damage = attacker.getAttackPower();

            System.out.println(
                    attacker.getName()
                            + " attacks "
                            + target.getName());

            target.takeDamage(damage);
        }

    }
}