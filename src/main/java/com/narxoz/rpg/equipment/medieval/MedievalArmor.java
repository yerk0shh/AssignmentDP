package com.narxoz.rpg.equipment.medieval;

import com.narxoz.rpg.equipment.Armor;

public class MedievalArmor implements Armor {

    @Override
    public String getArmorInfo() {
        return "Plate Armor";
    }

    @Override
    public int getDefense() {
        return 30;
    }
}
