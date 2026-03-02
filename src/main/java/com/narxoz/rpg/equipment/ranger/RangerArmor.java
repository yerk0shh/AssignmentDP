package com.narxoz.rpg.equipment.ranger;

import com.narxoz.rpg.equipment.Armor;

public class RangerArmor implements Armor {

    @Override
    public String getArmorInfo() {
        return "Leather Armor";
    }

    @Override
    public int getDefense() {
        return 20;
    }
}
