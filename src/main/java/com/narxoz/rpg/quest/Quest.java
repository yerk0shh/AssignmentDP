package com.narxoz.rpg.quest;

public final class Quest {
    private final String title;
    private final QuestPriority priority;
    private final int reward;
    private final String region;

    public Quest(String title, QuestPriority priority, int reward, String region) {
        this.title = title;
        this.priority = priority;
        this.reward = reward;
        this.region = region;
    }

    public String getTitle() { return title; }
    public QuestPriority getPriority() { return priority; }
    public int getReward() { return reward; }
    public String getRegion() { return region; }

    @Override
    public String toString() {
        return title + " [" + priority + ", reward=" + reward + ", region=" + region + "]";
    }
}
