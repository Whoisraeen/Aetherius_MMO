package net.raeen.aetheriusmod.factions;

import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FactionManager {
    private final Map<String, Faction> factions = new HashMap<>();

    public Faction createFaction(String name) {
        Faction faction = new Faction(name);
        factions.put(name, faction);
        return faction;
    }

    public Faction getFaction(String name) {
        return factions.get(name);
    }

    public Faction getFactionByPlayer(UUID playerId) {
        return factions.values().stream()
                .filter(faction -> faction.getMembers().containsKey(playerId))
                .findFirst()
                .orElse(null);
    }

    public void assignFactionQuest(ServerPlayer player, FactionQuest quest) {
        Faction faction = getFactionByPlayer(player.getUUID());
        if (faction != null) {
            // Logic to assign faction quest to the player
        }
    }

    public void completeFactionQuest(ServerPlayer player) {
        UUID playerId = player.getUUID();
        Faction faction = getFactionByPlayer(playerId);
        if (faction != null) {
            // Logic to complete the faction quest and give rewards
        }
    }
}
