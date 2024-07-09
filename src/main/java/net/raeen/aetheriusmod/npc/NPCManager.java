package net.raeen.aetheriusmod.npc;

import net.raeen.aetheriusmod.quests.Quest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NPCManager {
    private final Map<String, NPC> npcs = new HashMap<>();

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
NPCManager npcManager = new NPCManager();

private Quest mainQuest;
NPC elvenNPC = new NPC(
        "Elrond",
        "Elf",
        "Verdantra",
        Arrays.asList("Welcome to Verdantra, traveler.", "May your journey be prosperous."),
        Arrays.asList(mainQuest, sideQuest1, sideQuest2)
);

npcManager.addNPC(elvenNPC);
