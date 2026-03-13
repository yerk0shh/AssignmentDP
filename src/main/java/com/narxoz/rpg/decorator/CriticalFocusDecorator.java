package com.narxoz.rpg.decorator;

public class CriticalFocusDecorator extends ActionDecorator {

    public CriticalFocusDecorator(AttackAction action) {
        super(action);
    }

    @Override
    public int execute() {
        int damage = wrappedAction.execute();
        System.out.println("Critical Focus doubles damage!");
        return damage * 2;
    }

    @Override
    public String getDescription() {
        return wrappedAction.getDescription() + " + Critical Focus";
    }
}
