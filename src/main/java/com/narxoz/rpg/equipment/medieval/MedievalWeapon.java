package com.narxoz.rpg.equipment.medieval;

import com.narxoz.rpg.equipment.Weapon;

public class MedievalWeapon implements Weapon {

    @Override
    public String getWeaponInfo() {
        return "Iron Sword";
    }

    @Override
    public int getDamage() {
        return 25;
    }
}
