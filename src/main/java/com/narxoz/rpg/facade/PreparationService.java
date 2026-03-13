package com.narxoz.rpg.facade;

import com.narxoz.rpg.hero.Hero;

public class PreparationService {

    public void prepareHero(Hero hero) {
        System.out.println("Preparing hero: " + hero.getName());
        System.out.println("Hero sharpens weapon and gets ready.");
    }
}
