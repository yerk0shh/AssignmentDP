package com.narxoz.rpg.characters;

import com.narxoz.rpg.equipment.*;

public abstract class BaseCharacter implements GameCharacter {

    protected String name;
    protected int health;
    protected int mana;
    protected int strength;
    protected int intelligence;

    protected Weapon weapon;
    protected Armor armor;

    @Override
    public void equip(EquipmentFactory factory) {
        weapon = factory.createWeapon();
        armor = factory.createArmor();
    }

    @Override
    public void getStats() {
        System.out.println("=== " + name + " ===");
        System.out.println("Health: " + health);
        System.out.println("Mana: " + mana);
        System.out.println("Strength: " + strength);
        System.out.println("Intelligence: " + intelligence);

        if (weapon != null)
            System.out.println("Weapon: " + weapon.getWeaponInfo());

        if (armor != null)
            System.out.println("Armor: " + armor.getArmorInfo());
    }
}
