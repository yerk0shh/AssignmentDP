package com.narxoz.rpg.quest;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class RewardSortedQuestIterator implements QuestIterator {
    private final List<Quest> snapshot;
    private int cursor;

    public RewardSortedQuestIterator(QuestLog questLog) {
        this.snapshot = questLog.snapshot();
        this.snapshot.sort(Comparator.comparingInt(Quest::getReward).reversed());
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
