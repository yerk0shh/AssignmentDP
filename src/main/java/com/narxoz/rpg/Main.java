package com.narxoz.rpg;

import com.narxoz.rpg.characters.*;
import com.narxoz.rpg.composite.*;
import com.narxoz.rpg.bridge.*;
import com.narxoz.rpg.bridge.effects.*;
import com.narxoz.rpg.raid.*;

public class Main {

    public static void main(String[] args) {

        // Heroes
        HeroUnit warrior = new HeroUnit(new Warrior());
        HeroUnit mage = new HeroUnit(new Mage());
        HeroUnit archer = new HeroUnit(new Archer());

        // Enemies
        EnemyUnit goblin = new EnemyUnit(new Warrior());
        EnemyUnit orc = new EnemyUnit(new Archer());

        // Party
        PartyComposite heroParty = new PartyComposite();
        heroParty.add(warrior);
        heroParty.add(mage);
        heroParty.add(archer);

        PartyComposite enemyParty = new PartyComposite();
        enemyParty.add(goblin);
        enemyParty.add(orc);

        // RaidGroup (nested composite)
        RaidGroup raid = new RaidGroup();
        raid.add(heroParty);

        System.out.println("**** RAID STRUCTURE ****");
        raid.printTree("");

        // Bridge demo
        Skill fireball = new AreaSkill(new FireEffect());
        Skill iceStrike = new SingleTargetSkill(new IceEffect());

        fireball.use(enemyParty, 20);
        iceStrike.use(orc, 15);

        // Raid battle
        RaidEngine engine = new RaidEngine();

        RaidResult result = engine.runRaid(heroParty, enemyParty);

        System.out.println("\n**** RAID RESULT ****");
        result.printLog();
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
    }
}