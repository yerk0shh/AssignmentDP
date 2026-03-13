package com.narxoz.rpg.facade;

import com.narxoz.rpg.hero.Hero;
import com.narxoz.rpg.enemy.Enemy;

public class BattleService {

    public boolean startBattle(Hero hero, Enemy enemy) {

        System.out.println("\n=== Battle Begins ===");

        int round = 1;
        int enemyHealth = enemy.getHealth();

        while (hero.getHp() > 0 && enemyHealth > 0) {

            System.out.println("\nRound " + round);

            int heroDamage = hero.attack();
            enemyHealth -= heroDamage;

            System.out.println(hero.getName() + " deals " + heroDamage + " damage!");
            System.out.println(enemy.getName() + " HP: " + enemy.getHealth());

            if (enemyHealth <= 0) {
                System.out.println("Enemy defeated!");
                return true;
            }

            int enemyDamage = enemy.getDamage();
            hero.takeDamage(enemyDamage);

            System.out.println(enemy.getName() + " deals " + enemyDamage + " damage!");
            System.out.println(hero.getName() + " HP: " + hero.getHp());

            if (hero.getHp() <= 0) {
                System.out.println(hero.getName() + " has been defeated...");
                return false;
            }

            round++;
        }

        return hero.getHp() > 0;
    }
}
