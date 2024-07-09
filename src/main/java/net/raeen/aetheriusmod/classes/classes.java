package net.raeen.aetheriusmod.classes;

import java.util.HashMap;
import java.util.Map;

public class Classes {
    public static final Map<String, CharacterClass> classes = new HashMap<>();

    static {
        classes.put("Warblade", new CharacterClass("Warblade", new String[]{"Blade Mastery", "Battle Frenzy"}));
        classes.put("Spellweaver", new CharacterClass("Spellweaver", new String[]{"Elemental Mastery", "Mana Surge"}));
        classes.put("Beastlord", new CharacterClass("Beastlord", new String[]{"Animal Bond", "Wild Fury"}));
        classes.put("Shapeshifter", new CharacterClass("Shapeshifter", new String[]{"Form Change", "Adaptive Resilience"}));
        classes.put("Windrunner", new CharacterClass("Windrunner", new String[]{"Swift Strike", "Evasion"}));
        classes.put("Seraph", new CharacterClass("Seraph", new String[]{"Holy Smite", "Divine Protection"}));
        classes.put("Shadowblade", new CharacterClass("Shadowblade", new String[]{"Stealth", "Backstab"}));
        classes.put("Mindbender", new CharacterClass("Mindbender", new String[]{"Telekinesis", "Mind Control"}));
        classes.put("Sentinel", new CharacterClass("Sentinel", new String[]{"Shield Mastery", "Guardian Stance"}));
        classes.put("Nature's Oracle", new CharacterClass("Nature's Oracle", new String[]{"Nature's Wrath", "Healing Herbs"}));
        classes.put("Nightblade", new CharacterClass("Nightblade", new String[]{"Shadow Strike", "Silent Step"}));
        classes.put("Tempestcaller", new CharacterClass("Tempestcaller", new String[]{"Storm Mastery", "Lightning Bolt"}));
    }
}
