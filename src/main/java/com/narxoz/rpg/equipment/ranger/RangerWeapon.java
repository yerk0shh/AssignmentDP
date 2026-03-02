package com.narxoz.rpg.equipment.ranger;

import com.narxoz.rpg.equipment.Weapon;

public class RangerWeapon implements Weapon {

    @Override
    public String getWeaponInfo() {
        return "Longbow";
    }

    @Override
    public int getDamage() {
        return 30;
    }
}
