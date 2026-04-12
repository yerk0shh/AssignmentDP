package com.narxoz.rpg.combatant;

import com.narxoz.rpg.strategy.*;
import com.narxoz.rpg.observer.*;

public class DungeonBoss implements GameObserver {

    private int hp;
    private int maxHp;
    private int attack;
    private int defense;

    private int phase = 1;
    private CombatStrategy strategy;

    // Конструктор
    public DungeonBoss(int hp, int attack, int defense) {
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
        this.defense = defense;
        this.strategy = new BossPhase1Strategy();
    }

    //  Босс получает урон
    public void takeDamage(int damage, EventManager manager) {

        int finalDamage = Math.max(0, damage - strategy.calculateDefense(defense));
        hp -= finalDamage;

        if (hp < 0) hp = 0;

        int percent = (hp * 100) / maxHp;


        if (percent <= 60 && phase == 1) {
            phase = 2;
            manager.notify(new GameEvent(
                    GameEventType.BOSS_PHASE_CHANGED,
                    "Boss",
                    2
            ));
        }

        if (percent <= 30 && phase == 2) {
            phase = 3;
            manager.notify(new GameEvent(
                    GameEventType.BOSS_PHASE_CHANGED,
                    "Boss",
                    3
            ));
        }

        if (hp == 0) {
            manager.notify(new GameEvent(
                    GameEventType.BOSS_DEFEATED,
                    "Boss",
                    0
            ));
        }
    }

    // Атака босса
    public int attack() {
        return strategy.calculateDamage(attack);
    }

    // Strategy Changes here
    @Override
    public void onEvent(GameEvent event) {

        if (event.getType() == GameEventType.BOSS_PHASE_CHANGED) {

            if (event.getValue() == 2) {
                strategy = new BossPhase2Strategy();
            }

            if (event.getValue() == 3) {
                strategy = new BossPhase3Strategy();
            }

            System.out.println("🔥 Boss switched to " + strategy.getName());
        }
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return "Boss";
    }
}