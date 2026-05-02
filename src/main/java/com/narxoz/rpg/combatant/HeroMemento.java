package com.narxoz.rpg.combatant;

import com.narxoz.rpg.artifact.Artifact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HeroMemento {
    private final int hp;
    private final int mana;
    private final int gold;
    private final List<Artifact> inventory;

    HeroMemento(int hp, int mana, int gold, List<Artifact> inventory) {
        this.hp = hp;
        this.mana = mana;
        this.gold = gold;
        this.inventory = new ArrayList<>(inventory);
    }

    int getHp() {
        return hp;
    }

    int getMana() {
        return mana;
    }

    int getGold() {
        return gold;
    }

    List<Artifact> getInventory() {
        return Collections.unmodifiableList(inventory);
    }
}
