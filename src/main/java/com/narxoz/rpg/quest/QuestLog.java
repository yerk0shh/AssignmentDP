package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;

public class QuestLog {
    private final List<Quest> quests = new ArrayList<>();

    public void add(Quest quest) {
        quests.add(quest);
    }

    public int size() {
        return quests.size();
    }

    List<Quest> snapshot() {
        return new ArrayList<>(quests);
    }

    public QuestIterator ordered() {
        return new OrderedQuestIterator(this);
    }

    public QuestIterator reverse() {
        return new ReverseQuestIterator(this);
    }

    public QuestIterator priorityAtLeast(QuestPriority priority) {
        return new PriorityQuestIterator(this, priority);
    }

    public QuestIterator rewardSorted() {
        return new RewardSortedQuestIterator(this);
    }
}
