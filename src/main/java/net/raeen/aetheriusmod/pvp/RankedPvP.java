package net.raeen.aetheriusmod.pvp;

import net.minecraft.server.level.ServerPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RankedPvP {
    private final Map<UUID, Integer> playerRanks = new HashMap<>();

    public void addPlayer(ServerPlayer player) {
        playerRanks.put(player.getUUID(), 0);
    }

    public int getRank(ServerPlayer player) {
        return playerRanks.getOrDefault(player.getUUID(), 0);
    }

    public void updateRank(ServerPlayer player, int points) {
        playerRanks.put(player.getUUID(), getRank(player) + points);
    }

    public void startRankedMatch(ServerPlayer player1, ServerPlayer player2) {
        // Logic to start ranked PvP match
    }

    public void endRankedMatch(ServerPlayer winner, ServerPlayer loser) {
        updateRank(winner, 10);
        updateRank(loser, -5);
    }
}
