package com.narxoz.rpg.decorator;

public class PoisonCoatingDecorator extends ActionDecorator {

    public PoisonCoatingDecorator(AttackAction action) {
        super(action);
    }

    @Override
    public int execute() {
        int damage = wrappedAction.execute();
        System.out.println("☠️ Poison coating adds 3 poison damage!");
        return damage + 3;
    }

    @Override
    public String getDescription() {
        return wrappedAction.getDescription() + " + Poison Coating";
    }
}
