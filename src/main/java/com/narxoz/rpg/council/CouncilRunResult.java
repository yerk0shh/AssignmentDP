package com.narxoz.rpg.council;

public final class CouncilRunResult {
    private final int heroes;
    private final int quests;
    private final int plannedUrgentQuests;
    private final int guildMessages;

    public CouncilRunResult(int heroes, int quests, int plannedUrgentQuests, int guildMessages) {
        this.heroes = heroes;
        this.quests = quests;
        this.plannedUrgentQuests = plannedUrgentQuests;
        this.guildMessages = guildMessages;
    }

    @Override
    public String toString() {
        return "CouncilRunResult{" +
                "heroes=" + heroes +
                ", quests=" + quests +
                ", plannedUrgentQuests=" + plannedUrgentQuests +
                ", guildMessages=" + guildMessages +
                '}';
    }
}
