package net.raeen.aetheriusmod.lore;

import java.util.HashMap;
import java.util.Map;

public class Lore {
    private final Map<String, String> loreEntries;

    public Lore() {
        this.loreEntries = new HashMap<>();
        initializeLore();
    }

    private void initializeLore() {
        loreEntries.put("Elf", "Elves are mystical beings with a strong connection to nature.");
        loreEntries.put("Dwarf", "Dwarves are sturdy and resilient, known for their craftsmanship.");
        // Add more lore entries
    }

    public String getLore(String entry) {
        return loreEntries.getOrDefault(entry, "No lore available.");
    }
}
