package com.narxoz.rpg.characterfactory;

import com.narxoz.rpg.characters.*;

public class ArcherCreator extends CharacterCreator {

    @Override
    public GameCharacter createCharacter() {
        return new Archer();
    }
}
