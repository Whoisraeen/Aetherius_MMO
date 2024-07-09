package net.raeen.aetheriusmod.npc;

import net.raeen.aetheriusmod.quests.Quest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NPCManager {
    private final Map<String, NPC> npcs = new HashMap<>();
    NPCManager npcManager = new NPCManager();
    NPC elvenNPC = new NPC(
            "Elrond",
            "Elf",
            "Verdantra",
            Arrays.asList("Welcome to Verdantra, traveler.", "May your journey be prosperous."),
            Arrays.asList(mainQuest, sideQuest1, sideQuest2)
    );
    private Quest mainQuest;

    NPCManager(elvenNPC);

    public void addNPC(NPC npc) {
        npcs.put(npc.getName(), npc);
    }

    public NPC getNPC(String name) {
        return npcs.get(name);
    }

    public List<NPC> getNPCsByCity(String city) {
        return npcs.values().stream()
                .filter(npc -> npc.getCity().equals(city))
                .collect(Collectors.toList());
    }

    public void removeNPC(String name) {
        npcs.remove(name);
    }
}


