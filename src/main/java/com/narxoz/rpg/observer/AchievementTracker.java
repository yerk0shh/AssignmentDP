package com.narxoz.rpg.observer;

public class AchievementTracker implements GameObserver {

    private int attackCount = 0;

    @Override
    public void onEvent(GameEvent event) {

        switch (event.getType()) {

            case ATTACK_LANDED:
                attackCount++;
                if (attackCount == 5) {
                    System.out.println("🏆 Achievement unlocked: 5 hits!");
                }
                break;

            case HERO_DIED:
                System.out.println("💀 Achievement unlocked: First hero died!");
                break;

            case BOSS_DEFEATED:
                System.out.println("👑 Achievement unlocked: Boss defeated!");
                break;
        }
    }
}