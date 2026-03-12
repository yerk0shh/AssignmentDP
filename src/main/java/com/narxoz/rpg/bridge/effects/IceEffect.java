package com.narxoz.rpg.bridge.effects;

import com.narxoz.rpg.composite.CombatNode;

public class IceEffect implements EffectImplementor {

    @Override
    public void applyEffect(CombatNode target, int power) {

        System.out.println("Ice damage " + power + " ❄️");

        target.takeDamage(power);
    }
}