package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {

    public FireRuneDecorator(AttackAction action) {
        super(action);
    }

    @Override
    public int execute() {
        int damage = wrappedAction.execute();
        System.out.println("🔥 Fire Rune adds 5 fire damage!");
        return damage + 5;
    }

    @Override
    public String getDescription() {
        return wrappedAction.getDescription() + " + Fire Rune";
    }
}
