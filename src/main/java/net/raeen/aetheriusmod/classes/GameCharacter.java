package net.raeen.aetheriusmod.classes;

import net.raeen.aetheriusmod.classes.CharacterClass;
import net.raeen.aetheriusmod.races.Race;

import java.util.HashMap;
import java.util.Map;

public class GameCharacter {
    private String name;
    private Race race;
    private CharacterClass characterClass;
    private String appearance;
    private Map<String, Integer> attributes;
    private Map<String, String> abilities;

    public GameCharacter(String name, Race race, CharacterClass characterClass, String appearance) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.appearance = appearance;
        this.attributes = new HashMap<>();
        this.abilities = new HashMap<>();
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

    public void setAttribute(String key, int value) {
        attributes.put(key, value);
    }

    public Map<String, String> getAbilities() {
        return abilities;
    }

    public void setAbility(String key, String value) {
        abilities.put(key, value);
    }

    public void displayCharacterInfo() {
        // Print character details
        System.out.println("Character: " + name);
        System.out.println("Race: " + race.getName());
        System.out.println("Class: " + characterClass.getName());
        System.out.println("Appearance: " + appearance);
        System.out.println("Attributes: " + attributes);
        System.out.println("Abilities: " + abilities);
    }
}
