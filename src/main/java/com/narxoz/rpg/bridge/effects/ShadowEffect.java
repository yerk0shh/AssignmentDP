package com.narxoz.rpg.bridge.effects;

import com.narxoz.rpg.composite.CombatNode;

public class ShadowEffect implements EffectImplementor {

    @Override
    public void applyEffect(CombatNode target, int power) {

        int damage = power + 3;

        System.out.println("Shadow damage " + damage + " 🌑");

        target.takeDamage(damage);
    }
}