package com.narxoz.rpg;

import com.narxoz.rpg.decorator.*;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.hero.Hero;
import com.narxoz.rpg.enemy.BasicEnemy;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== RPG Dungeon Run Demo ===");

        //Base attack
        AttackAction basicAttack = new BasicAttack();
        System.out.println("\nBase Attack:");
        System.out.println(basicAttack.getDescription());
        System.out.println("Damage: " + basicAttack.execute());

        //Decorated attack
        AttackAction fireAttack =
                new FireRuneDecorator(new BasicAttack());

        System.out.println("\nDecorated Attack:");
        System.out.println(fireAttack.getDescription());
        System.out.println("Damage: " + fireAttack.execute());

        //Multiple decorators stacked
        AttackAction ultimateAttack =
                new CriticalFocusDecorator(
                        new PoisonCoatingDecorator(
                                new FireRuneDecorator(
                                        new BasicAttack()
                                )
                        )
                );

        System.out.println("\nStacked Decorators Attack:");
        System.out.println(ultimateAttack.getDescription());
        System.out.println("Damage: " + ultimateAttack.execute());

        //Create hero with decorated attack
        Hero hero = new Hero("Knight", 100, ultimateAttack);

        //Create enemy
        BasicEnemy boss = new BasicEnemy("Dragon", 120);

        //Run dungeon through Facade
        DungeonFacade dungeon = new DungeonFacade();
        AdventureResult result = dungeon.runDungeon(hero, boss);

        System.out.println("\n=== Adventure Summary ===");
        System.out.println(result);
    }
}
