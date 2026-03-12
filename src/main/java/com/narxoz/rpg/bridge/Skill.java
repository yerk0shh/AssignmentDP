package com.narxoz.rpg.bridge;

import com.narxoz.rpg.bridge.effects.EffectImplementor;
import com.narxoz.rpg.composite.CombatNode;

public abstract class Skill {

    protected EffectImplementor effect;

    public Skill(EffectImplementor effect){
        this.effect = effect;
    }

    public abstract void use(CombatNode target, int power);
}