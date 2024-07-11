package net.raeen.aetheriusmod.progression;

import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LevelingSystem {
    private final Map<UUID, PlayerProgression> playerProgressions;

    public LevelingSystem() {
        this.playerProgressions = new HashMap<>();
    }

    public void addPlayer(ServerPlayer player) {
        playerProgressions.put(player.getUUID(), new PlayerProgression(player.getUUID()));
    }

    public void addExperience(ServerPlayer player, double amount) {
        PlayerProgression progression = playerProgressions.get(player.getUUID());
        if (progression != null) {
            progression.addExperience(amount);
        }
    }

    public PlayerProgression getPlayerProgression(ServerPlayer player) {
        return playerProgressions.get(player.getUUID());
    }

    public Map<UUID, PlayerProgression> getPlayerProgressions() {
        return null;
    }
}
