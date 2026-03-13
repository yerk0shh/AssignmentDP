package com.narxoz.rpg.decorator;

public abstract class ActionDecorator implements AttackAction {

    protected AttackAction wrappedAction;

    public ActionDecorator(AttackAction action) {
        this.wrappedAction = action;
    }
}
