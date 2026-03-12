package com.narxoz.rpg.bridge.effects;

import com.narxoz.rpg.composite.CombatNode;

public class PhysicalEffect implements EffectImplementor {

    @Override
    public void applyEffect(CombatNode target, int power) {

        System.out.println("Physical strike deals " + power + " damage ⚔️");

        target.takeDamage(power);
    }
}