package net.raeen.aetheriusmod.character;

import net.raeen.aetheriusmod.classes.CharacterClass;
import net.raeen.aetheriusmod.items.Item;
import net.raeen.aetheriusmod.progression.Progression;
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
    private final Map<String, Integer> attributes;
    private final Progression progression;
    private final List<Quest> activeQuests;
    private final Map<String, Item> equipment;

    public GameCharacter(String name, Race race, CharacterClass characterClass, String appearance) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.appearance = appearance;
        this.attributes = new HashMap<>();
        this.progression = new Progression();
        this.activeQuests = new ArrayList<>();
        this.equipment = new HashMap<>();

        // Apply racial abilities
        this.race.applyRacialAbilities(this);
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
            // Additional code to handle item and currency rewards
        }
    }

    public void equipItem(Item item) {
        equipment.put(item.getItemType(), item);
    }

    public Item getEquippedItem(String itemType) {
        return equipment.get(itemType);
    }
}
