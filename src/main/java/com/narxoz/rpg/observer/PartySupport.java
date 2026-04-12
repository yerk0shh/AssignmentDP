package com.narxoz.rpg.observer;

public class PartySupport implements GameObserver {

    @Override
    public void onEvent(GameEvent event) {

        if (event.getType() == GameEventType.HERO_LOW_HP) {
            System.out.println("✨ PartySupport heals an ally!");
        }
    }
}