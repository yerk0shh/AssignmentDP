package com.narxoz.rpg.facade;

import com.narxoz.rpg.hero.Hero;
import com.narxoz.rpg.enemy.Enemy;

public class BattleService {

    public boolean startBattle(Hero hero, Enemy enemy) {

        System.out.println("Battle begins!");

        int heroDamage = hero.attack();
        System.out.println("Hero attacks for " + heroDamage + " damage!");

        System.out.println("Enemy defeated!");

        return true;
    }
}
