package com.narxoz.rpg.quest;

import java.util.List;
import java.util.NoSuchElementException;

public class OrderedQuestIterator implements QuestIterator {
    private final List<Quest> snapshot;
    private int cursor;

    public OrderedQuestIterator(QuestLog questLog) {
        this.snapshot = questLog.snapshot();
    }

    @Override
    public boolean hasNext() {
        return cursor < snapshot.size();
    }

    @Override
    public Quest next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return snapshot.get(cursor++);
    }
}
