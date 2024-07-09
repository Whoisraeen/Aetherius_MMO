package net.raeen.aetheriusmod.skills;

public class Skill {
    private String name;
    private String description;
    private int levelRequirement;
    private int maxLevel;
    private int currentLevel;

    public Skill(String name, String description, int levelRequirement, int maxLevel) {
        this.name = name;
        this.description = description;
        this.levelRequirement = levelRequirement;
        this.maxLevel = maxLevel;
        this.currentLevel = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void levelUp() {
        if (currentLevel < maxLevel) {
            currentLevel++;
        }
    }
}
