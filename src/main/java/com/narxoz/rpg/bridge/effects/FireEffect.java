package com.narxoz.rpg.bridge.effects;

import com.narxoz.rpg.composite.CombatNode;

public class FireEffect implements EffectImplementor {

    @Override
    public void applyEffect(CombatNode target, int power) {

        int damage = power + 5;

        System.out.println("Fire burns enemy for " + damage + " damage 🔥");

        target.takeDamage(damage);
    }
}