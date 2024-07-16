package net.raeen.aetheriusmod.quests;

import java.util.List;

public class Quest {
    private final String title;
    private final String description;
    private final List<String> objectives;
    private final int rewardExperience;
    private final List<String> rewards;
    private final int difficulty;
    private int currentStage;
    private List<String> stages;

    public Quest(String title, String description, List<String> objectives, int rewardExperience, List<String> rewards, int difficulty) {
        this.title = title;
        this.description = description;
        this.objectives = objectives;
        this.rewardExperience = rewardExperience;
        this.rewards = rewards;
        this.difficulty = difficulty;
        this.currentStage = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getObjectives() {
        return objectives;
    }

    public int getRewardExperience() {
        return rewardExperience;
    }

    public List<String> getRewards() {
        return rewards;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getCurrentStage() {
        return currentStage;
    }

    public void advanceStage() {
        if (currentStage < stages.size() - 1) {
            currentStage++;
        }
    }

    public String getCurrentObjective() {
        return objectives.get(currentStage);
    }

    public void setStages(List<String> stages) {
        this.stages = stages;
    }

    public String getName() {
        return null;
    }
}
