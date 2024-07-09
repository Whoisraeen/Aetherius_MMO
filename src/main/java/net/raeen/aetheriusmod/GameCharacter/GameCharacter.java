package net.raeen.aetheriusmod.character;

import net.raeen.aetheriusmod.abilities.Ability;
import net.raeen.aetheriusmod.attributes.Attributes;
import net.raeen.aetheriusmod.classes.CharacterClass;
import net.raeen.aetheriusmod.races.Race;

import java.util.HashMap;
import java.util.Map;

public class GameCharacter {
    private String name;
    private Race race;
    private CharacterClass characterClass;
    private String appearance;
    private Attributes attributes;
    private Map<String, Ability> abilities;

    public GameCharacter(String name, Race race, CharacterClass characterClass, String appearance) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.appearance = appearance;
        this.attributes = new Attributes();
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

    public Attributes getAttributes() {
        return attributes;
    }

    public void addAbility(Ability ability) {
        abilities.put(ability.getName(), ability);
    }

    public Map<String, Ability> getAbilities() {
        return abilities;
    }

    public void displayCharacterInfo() {
        // Print character details
        System.out.println("Character: " + name);
        System.out.println("Race: " + race.getName());
        System.out.println("Class: " + characterClass.getName());
        System.out.println("Appearance: " + appearance);
        System.out.println("Attributes: " + attributes.getAllAttributes());
        System.out.println("Abilities: ");
        abilities.values().forEach(ability -> System.out.println(" - " + ability.getName() + ": " + ability.getDescription()));
    }
}
