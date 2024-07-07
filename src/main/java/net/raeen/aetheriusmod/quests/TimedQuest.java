package net.raeen.aetheriusmod.quests;

import java.util.List;

public class TimedQuest extends Quest {
    private final int timeLimit; // in seconds

    public TimedQuest(String name, String description, List<String> objectives, int experienceReward, List<String> itemRewards, int currencyReward, int timeLimit) {
        super(name, description, objectives, experienceReward, itemRewards, currencyReward);
        this.timeLimit = timeLimit;
    }

    public int getTimeLimit() {
        return timeLimit;
    }
}
