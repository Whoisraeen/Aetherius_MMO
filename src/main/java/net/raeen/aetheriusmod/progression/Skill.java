package net.raeen.aetheriusmod.progression;

public class Skill {
    private final String name;
    private final String description;
    private int level;
    private final int maxLevel;

    public Skill(String name, String description, int maxLevel) {
        this.name = name;
        this.description = description;
        this.level = 1;
        this.maxLevel = maxLevel;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void upgrade() {
        if (level < maxLevel) {
            level++;
        }
    }
}
