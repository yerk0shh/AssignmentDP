package com.narxoz.rpg.equipment.magic;

import com.narxoz.rpg.equipment.Weapon;

public class MagicWeapon implements Weapon {

    @Override
    public String getWeaponInfo() {
        return "Wizard Staff";
    }

    @Override
    public int getDamage() {
        return 15;
    }
}
