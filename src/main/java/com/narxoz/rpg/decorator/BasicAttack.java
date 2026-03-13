package com.narxoz.rpg.decorator;

public class BasicAttack implements AttackAction {

    @Override
    public int execute() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Basic Attack";
    }
}
