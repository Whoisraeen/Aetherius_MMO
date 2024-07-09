package net.raeen.aetheriusmod.quests;

import java.util.UUID;

public class DailyQuest {
    private String title;
    private String description;
    private UUID questGiver;
    private int reward;

    public DailyQuest(String title, String description, UUID questGiver, int reward) {
        this.title = title;
        this.description = description;
        this.questGiver = questGiver;
        this.reward = reward;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public UUID getQuestGiver() {
        return questGiver;
    }

    public int getReward() {
        return reward;
    }
}
