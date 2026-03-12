package com.narxoz.rpg.bridge.effects;

import com.narxoz.rpg.composite.CombatNode;

public interface EffectImplementor {

    void applyEffect(CombatNode target, int power);
}