package com.narxoz.rpg.observer;

public class GameEvent {

    private GameEventType type;
    private String sourceName;
    private int value;

    public GameEvent(GameEventType type, String sourceName, int value) {
        this.type = type;
        this.sourceName = sourceName;
        this.value = value;
    }

    public GameEventType getType() {
        return type;
    }

    public String getSourceName() {
        return sourceName;
    }

    public int getValue() {
        return value;
    }
}