package com.narxoz.rpg.characterfactory;

import com.narxoz.rpg.characters.*;

public class WarriorCreator extends CharacterCreator {

    @Override
    public GameCharacter createCharacter() {
        return new Warrior();
    }
}
