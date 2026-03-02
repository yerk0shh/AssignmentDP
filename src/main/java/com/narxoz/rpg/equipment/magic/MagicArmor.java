package com.narxoz.rpg.equipment.magic;

import com.narxoz.rpg.equipment.Armor;

public class MagicArmor implements Armor {

    @Override
    public String getArmorInfo() {
        return "Enchanted Robe";
    }

    @Override
    public int getDefense() {
        return 10;
    }
}
