package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class IceLootTable implements LootTable {

    private final List<String> items;
    private final int goldDrop;
    private final int experienceDrop;

    public IceLootTable() {
        items = new ArrayList<>();
        items.add("Ice Gem");
        items.add("Frost Scale");
        items.add("Ice Rune");

        goldDrop = 400;
        experienceDrop = 900;
    }

    private IceLootTable(List<String> items, int gold, int exp) {
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
        return new IceLootTable(new ArrayList<>(items), goldDrop, experienceDrop);
    }
}