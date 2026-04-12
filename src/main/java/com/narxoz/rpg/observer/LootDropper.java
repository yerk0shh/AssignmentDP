package com.narxoz.rpg.observer;

public class LootDropper implements GameObserver {

    @Override
    public void onEvent(GameEvent event) {

        if (event.getType() == GameEventType.BOSS_PHASE_CHANGED) {
            System.out.println("💰 Loot dropped for new phase!");
        }

        if (event.getType() == GameEventType.BOSS_DEFEATED) {
            System.out.println("💎 FINAL LOOT DROPPED!");
        }
    }
}