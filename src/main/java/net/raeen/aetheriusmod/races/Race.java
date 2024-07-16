package net.raeen.aetheriusmod.races;

import net.raeen.aetheriusmod.classes.GameCharacter;

import java.util.HashMap;
import java.util.Map;

public abstract class Race {
    private final String name;
    private final String[] abilities;

    public Race(String name, String[] abilities) {
        this.name = name;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public String[] getAbilities() {
        return abilities;
    }

    public static final Map<String, Race> races = new HashMap<>();

    static {
        races.put("Aelorian", new Race("Aelorian", new String[]{"Arcane Mastery", "Ancient Wisdom"}) {
            @Override
            public void applyRacialAbilities(GameCharacter character) {

            }
        });
        races.put("Lycan", new Race("Lycan", new String[]{"Feral Strength", "Enhanced Senses"}) {
            @Override
            public void applyRacialAbilities(GameCharacter character) {

            }
        });
        races.put("Celestial", new Race("Celestial", new String[]{"Divine Light", "Healing Touch"}) {
            @Override
            public void applyRacialAbilities(GameCharacter character) {

            }
        });
        races.put("Aquafae", new Race("Aquafae", new String[]{"Water Manipulation", "Aquatic Adaptation"}) {
            @Override
            public void applyRacialAbilities(GameCharacter character) {

            }
        });
        races.put("Terran", new Race("Terran", new String[]{"Earth Mastery", "Stone Skin"}) {
            @Override
            public void applyRacialAbilities(GameCharacter character) {

            }
        });
        races.put("Umbral", new Race("Umbral", new String[]{"Shadow Manipulation", "Night Vision"}) {
            @Override
            public void applyRacialAbilities(GameCharacter character) {

            }
        });
    }

    public abstract void applyRacialAbilities(GameCharacter character);
}
