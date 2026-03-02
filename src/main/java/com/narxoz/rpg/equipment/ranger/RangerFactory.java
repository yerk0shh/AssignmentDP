package com.narxoz.rpg.equipment.ranger;

import com.narxoz.rpg.equipment.*;

public class RangerFactory implements EquipmentFactory {

    @Override
    public Weapon createWeapon() {
        return new RangerWeapon();
    }

    @Override
    public Armor createArmor() {
        return new RangerArmor();
    }
}
