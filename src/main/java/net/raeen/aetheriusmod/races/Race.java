package net.raeen.aetheriusmod.races;

import net.raeen.aetheriusmod.character.GameCharacter;

import java.util.Arrays;
import java.util.List;

public class Races {
    public static final Map<String, Race> races = new HashMap<>();

    static {
        races.put("Aelorian", new Race("Aelorian", new String[]{"Arcane Mastery", "Ancient Wisdom"}));
        races.put("Lycan", new Race("Lycan", new String[]{"Feral Strength", "Enhanced Senses"}));
        races.put("Celestial", new Race("Celestial", new String[]{"Divine Light", "Healing Touch"}));
        races.put("Aquafae", new Race("Aquafae", new String[]{"Water Manipulation", "Aquatic Adaptation"}));
        races.put("Terran", new Race("Terran", new String[]{"Earth Mastery", "Stone Skin"}));
        races.put("Umbral", new Race("Umbral", new String[]{"Shadow Manipulation", "Night Vision"}));
    }
}