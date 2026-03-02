package com.narxoz.rpg.ability;

public interface Ability extends Cloneable {

    String getName();

    int getDamage();

    String getDescription();

    Ability clone();
}