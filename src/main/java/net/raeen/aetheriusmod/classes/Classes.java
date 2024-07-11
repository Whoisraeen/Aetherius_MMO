package net.raeen.aetheriusmod.classes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Classes {
    public static final Map<String, CharacterClass> classes = new HashMap<>();

    static {
        classes.put("Warblade", new CharacterClass("Warblade", Arrays.asList("Blade Mastery", "Battle Frenzy")));
        classes.put("Spellweaver", new CharacterClass("Spellweaver", Arrays.asList("Elemental Mastery", "Mana Surge")));
        classes.put("Beastlord", new CharacterClass("Beastlord", Arrays.asList("Animal Bond", "Wild Fury")));
        classes.put("Shapeshifter", new CharacterClass("Shapeshifter", Arrays.asList("Form Change", "Adaptive Resilience")));
        classes.put("Windrunner", new CharacterClass("Windrunner", Arrays.asList("Swift Strike", "Evasion")));
        classes.put("Seraph", new CharacterClass("Seraph", Arrays.asList("Holy Smite", "Divine Protection")));
        classes.put("Shadowblade", new CharacterClass("Shadowblade", Arrays.asList("Stealth", "Backstab")));
        classes.put("Mindbender", new CharacterClass("Mindbender", Arrays.asList("Telekinesis", "Mind Control")));
        classes.put("Sentinel", new CharacterClass("Sentinel", Arrays.asList("Shield Mastery", "Guardian Stance")));
        classes.put("Nature's Oracle", new CharacterClass("Nature's Oracle", Arrays.asList("Nature's Wrath", "Healing Herbs")));
        classes.put("Nightblade", new CharacterClass("Nightblade", Arrays.asList("Shadow Strike", "Silent Step")));
        classes.put("Tempestcaller", new CharacterClass("Tempestcaller", Arrays.asList("Storm Mastery", "Lightning Bolt")));
    }
}
