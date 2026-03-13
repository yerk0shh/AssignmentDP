package com.narxoz.rpg.facade;

import com.narxoz.rpg.hero.Hero;

public class RewardService {

    public AdventureResult grantRewards(Hero hero, boolean heroWon) {

        int gold = 0;

        if (heroWon) {
            gold = 100;
            System.out.println(hero.getName() + " wins the dungeon!");
            System.out.println("Reward: " + gold + " gold");
        } else {
            System.out.println(hero.getName() + " was defeated...");
        }

        return new AdventureResult(heroWon, gold);
    }
}
