package com.narxoz.rpg.equipment.magic;

import com.narxoz.rpg.equipment.*;

public class MagicFactory implements EquipmentFactory {

    @Override
    public Weapon createWeapon() {
        return new MagicWeapon();
    }

    @Override
    public Armor createArmor() {
        return new MagicArmor();
    }
}
