package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PriorityQuestIterator implements QuestIterator {
    private final List<Quest> snapshot = new ArrayList<>();
    private int cursor;

    public PriorityQuestIterator(QuestLog questLog, QuestPriority threshold) {
        for (Quest quest : questLog.snapshot()) {
            if (quest.getPriority().ordinal() >= threshold.ordinal()) {
                snapshot.add(quest);
            }
        }
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
