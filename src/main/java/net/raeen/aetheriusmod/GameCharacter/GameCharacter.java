package net.raeen.aetheriusmod.character;

import net.raeen.aetheriusmod.classes.CharacterClass;
import net.raeen.aetheriusmod.quests.Quest;
import net.raeen.aetheriusmod.races.Race;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameCharacter {
    private final String name;
    private final Race race;
    private final CharacterClass characterClass;
    private final String appearance;
    private final List<Quest> questLog;
    private final Map<String, Integer> attributes;
    private int level;
    private int experience;

    public GameCharacter(String name, Race race, CharacterClass characterClass, String appearance) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.appearance = appearance;
        this.attributes = new HashMap<>();
        this.questLog = new ArrayList<>();
        this.level = 1;
        this.experience = 0;
    }

    public void acceptQuest(Quest quest) {
        questLog.add(quest);
    }

    public void completeQuest(Quest quest) {
        this.experience += quest.getRewardExperience();
        questLog.remove(quest);
        levelUp();
    }

    private void levelUp() {
        // Implement level up logic
        while (this.experience >= experienceToNextLevel()) {
            this.experience -= experienceToNextLevel();
            this.level++;
        }
    }

    private int experienceToNextLevel() {
        return this.level * 100; // Example formula for next level experience requirement
    }

    public void onDeath() {
        // Implement experience loss on death
        this.experience *= 0.9; // Lose 10% of current experience
    }
public int getAttribute(String attribute) {
    if (this.attributes.containsKey(attribute)) {
        return this.attributes.get(attribute);
    } else {
        return 0; // Default value if attribute does not exist
    }
}

    public void setAttribute(String health, int health1) {
    }

    public Object getName() {
        return null;
    }
    // Getters and additional methods
}
