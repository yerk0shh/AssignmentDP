package com.narxoz.rpg.bridge;

import com.narxoz.rpg.bridge.effects.EffectImplementor;
import com.narxoz.rpg.composite.CombatNode;

public class AreaSkill extends Skill {

    public AreaSkill(EffectImplementor effect) {
        super(effect);
    }

    @Override
    public void use(CombatNode target, int power) {

        System.out.println("Area skill hits multiple targets 💥");

        effect.applyEffect(target, power);
    }
}