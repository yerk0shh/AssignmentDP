package com.narxoz.rpg.raid;

import com.narxoz.rpg.composite.CombatNode;

public class RaidEngine {

    public RaidResult runRaid(CombatNode teamA, CombatNode teamB){

        RaidResult result = new RaidResult();

        int round = 0;

        while(teamA.isAlive() && teamB.isAlive()){

            round++;

            result.addLog("Round " + round);

            int attackA = teamA.getAttackPower();
            result.addLog("Team A attacks for " + attackA);

            teamB.takeDamage(attackA);

            if(!teamB.isAlive()){
                break;
            }

            int attackB = teamB.getAttackPower();
            result.addLog("Team B attacks for " + attackB);

            teamA.takeDamage(attackB);
        }

        result.setRounds(round);

        if(teamA.isAlive()){
            result.setWinner("Team A");
        } else {
            result.setWinner("Team B");
        }

        return result;
    }
}