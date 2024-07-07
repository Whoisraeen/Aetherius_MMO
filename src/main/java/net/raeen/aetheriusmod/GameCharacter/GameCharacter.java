package net.raeen.aetheriusmod.character;

import net.raeen.aetheriusmod.quests.Quest;
import net.raeen.aetheriusmod.races.Race;
import net.raeen.aetheriusmod.classes.CharacterClass;
import net.raeen.aetheriusmod.progression.Progression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameCharacter {
    private String name;
    private Race race;
    private CharacterClass characterClass;
    private String appearance;
    private Map<String, Integer> attributes;
    private Progression progression;
    private List<Quest> activeQuests;

    public GameCharacter(String name, Race race, CharacterClass characterClass, String appearance) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.appearance = appearance;
        this.attributes = new HashMap<>();
        this.progression = new Progression();
        this.activeQuests = new ArrayList<>();
    }

    public void setAttribute(String attribute, int value) {
        attributes.put(attribute, value);
    }

    public int getAttribute(String attribute) {
        return attributes.getOrDefault(attribute, 0);
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public String getAppearance() {
        return appearance;
    }

    public Map<String, Integer> getAttributes() {
        return attributes;
    }

    public Progression getProgression() {
        return progression;
    }

    public List<Quest> getActiveQuests() {
        return activeQuests;
    }

    public void acceptQuest(Quest quest) {
        activeQuests.add(quest);
    }

    public void completeQuest(Quest quest) {
        if (activeQuests.contains(quest)) {
            activeQuests.remove(quest);
            progression.gainExperience(quest.getExperienceReward());
            System.out.println("Quest Completed: " + quest.getName());
            System.out.println("Experience Gained: " + quest.getExperienceReward());
            System.out.println("Items Rewarded: " + String.join(", ", quest.getItemRewards()));
            System.out.println("Currency Rewarded: " + quest.getCurrencyReward());
        }
    }
}
