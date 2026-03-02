package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class FireLootTable implements LootTable {

    private final List<String> items;
    private final int goldDrop;
    private final int experienceDrop;

    public FireLootTable() {
        this.items = new ArrayList<>();
        items.add("Fire Gem");
        items.add("Dragon Scale");
        items.add("Flame Rune");

        this.goldDrop = 500;
        this.experienceDrop = 1000;
    }

    private FireLootTable(List<String> items, int goldDrop, int experienceDrop) {
        this.items = items;
        this.goldDrop = goldDrop;
        this.experienceDrop = experienceDrop;
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
        return new FireLootTable(new ArrayList<>(this.items), this.goldDrop, this.experienceDrop);
    }
}