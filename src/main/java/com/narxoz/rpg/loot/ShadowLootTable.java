package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class ShadowLootTable implements LootTable {

    private final List<String> items;
    private final int goldDrop;
    private final int experienceDrop;

    public ShadowLootTable() {
        items = new ArrayList<>();
        items.add("Shadow Gem");
        items.add("Dark Essence");
        items.add("Shadow Rune");

        goldDrop = 600;
        experienceDrop = 1200;
    }

    private ShadowLootTable(List<String> items, int gold, int exp) {
        this.items = items;
        this.goldDrop = gold;
        this.experienceDrop = exp;
    }

    @Override
    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public int getGoldDrop() {
        return goldDrop;
    }

    @Override
    public int getExperienceDrop() {
        return experienceDrop;
    }

    @Override
    public LootTable clone() {
        return new ShadowLootTable(new ArrayList<>(items), goldDrop, experienceDrop);
    }
}