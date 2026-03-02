package com.narxoz.rpg.equipment.medieval;

import com.narxoz.rpg.equipment.*;

public class MedievalFactory implements EquipmentFactory {

    @Override
    public Weapon createWeapon() {
        return new MedievalWeapon();
    }

    @Override
    public Armor createArmor() {
        return new MedievalArmor();
    }
}
