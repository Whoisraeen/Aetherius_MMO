package net.raeen.aetheriusmod.progression;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerProgression {
    private final UUID playerId;
    private int level;
    private double experience;
    private final Map<String, Achievement> achievements;
    private final Map<String, Title> titles;

    public PlayerProgression(UUID playerId) {
        this.playerId = playerId;
        this.level = 1;
        this.experience = 0.0;
        this.achievements = new HashMap<>();
        this.titles = new HashMap<>();
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public int getLevel() {
        return level;
    }

    public double getExperience() {
        return experience;
    }

    public void addExperience(double amount) {
        this.experience += amount;
        while (this.experience >= getExperienceForNextLevel()) {
            levelUp();
        }
    }

    private void levelUp() {
        this.level++;
        this.experience -= getExperienceForNextLevel();
    }

    private double getExperienceForNextLevel() {
        return this.level * 100; // Example formula for level-up experience
    }

    public void addAchievement(Achievement achievement) {
        achievements.put(achievement.getName(), achievement);
    }

    public void addTitle(Title title) {
        titles.put(title.getName(), title);
    }

    public Map<String, Achievement> getAchievements() {
        return achievements;
    }

    public Map<String, Title> getTitles() {
        return titles;
    }
}
