package com.narxoz.rpg.characterfactory;

import com.narxoz.rpg.characters.*;

public class MageCreator extends CharacterCreator {

    @Override
    public GameCharacter createCharacter() {
        return new Mage();
    }
}
