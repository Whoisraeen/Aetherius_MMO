package net.raeen.aetheriusmod.pvp;

import net.minecraft.server.level.ServerPlayer;
import java.util.UUID;

public class RankedPvPManager {
    private final RankedPvP rankedPvP = new RankedPvP();

    public void addPlayer(ServerPlayer player) {
        rankedPvP.addPlayer(player);
    }

    public int getRank(ServerPlayer player) {
        return rankedPvP.getRank(player);
    }

    public void startRankedMatch(ServerPlayer player1, ServerPlayer player2) {
        rankedPvP.startRankedMatch(player1, player2);
    }

    public void endRankedMatch(ServerPlayer winner, ServerPlayer loser) {
        rankedPvP.endRankedMatch(winner, loser);
    }
}
