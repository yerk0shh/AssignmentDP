package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;
import com.narxoz.rpg.bridge.effects.EffectImplementor;

public class SingleTargetSkill extends Skill {

    public SingleTargetSkill(EffectImplementor effect) {
        super(effect);
    }

    @Override
    public void use(CombatNode target, int power) {

        System.out.println("Single target skill used");

        effect.applyEffect(target, power);
    }
}