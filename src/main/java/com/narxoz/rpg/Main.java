package com.narxoz.rpg;

import com.narxoz.rpg.adapter.*;
import com.narxoz.rpg.battle.*;
import com.narxoz.rpg.characterfactory.*;
import com.narxoz.rpg.characters.GameCharacter;
import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== RPG BATTLE DEMO =====");

        BattleEngine engine1 = BattleEngine.getInstance();
        BattleEngine engine2 = BattleEngine.getInstance();

        System.out.println("Same BattleEngine instance: "
                + (engine1 == engine2));

        CharacterCreator warriorCreator =
                new WarriorCreator();
        GameCharacter warrior =
                warriorCreator.createCharacter();

        CharacterCreator mageCreator =
                new MageCreator();
        GameCharacter mage =
                mageCreator.createCharacter();

        EnemyDirector director = new EnemyDirector();

        /* FACTORIES (Elements) */
        EnemyComponentFactory fireFactory =
                new FireComponentFactory();

        EnemyComponentFactory iceFactory =
                new IceComponentFactory();

        EnemyBuilder minionBuilder =
                new BasicEnemyBuilder();

        EnemyBuilder bossBuilder =
                new BossEnemyBuilder();

        Enemy goblin =
                director.createMinion(
                        minionBuilder,
                        iceFactory);

        Enemy dragon =
                director.createRaidBoss(
                        bossBuilder,
                        fireFactory);

        List<Combatant> heroes = new ArrayList<>();
        heroes.add(new HeroCombatantAdapter(warrior));
        heroes.add(new HeroCombatantAdapter(mage));

        List<Combatant> enemies = new ArrayList<>();
        enemies.add(new EnemyCombatantAdapter(goblin));
        enemies.add(new EnemyCombatantAdapter(dragon));


        BattleEngine engine =
                BattleEngine.getInstance()
                        .setRandomSeed(42);

        EncounterResult result =
                engine.runEncounter(
                        heroes,
                        enemies
                );


        System.out.println("\n===== BATTLE RESULT =====");
        System.out.println(result);
    }
}