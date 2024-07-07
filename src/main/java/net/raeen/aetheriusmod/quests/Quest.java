package net.raeen.aetheriusmod.quests;

import java.util.List;

public class Quest {
    private String name;
    private String description;
    private List<String> objectives;
    private int experienceReward;
    private List<String> itemRewards;
    private int currencyReward;

    public Quest(String name, String description, List<String> objectives, int experienceReward, List<String> itemRewards, int currencyReward) {
        this.name = name;
        this.description = description;
        this.objectives = objectives;
        this.experienceReward = experienceReward;
        this.itemRewards = itemRewards;
        this.currencyReward = currencyReward;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getObjectives() {
        return objectives;
    }

    public int getExperienceReward() {
        return experienceReward;
    }

    public List<String> getItemRewards() {
        return itemRewards;
    }

    public int getCurrencyReward() {
        return currencyReward;
    }
}
