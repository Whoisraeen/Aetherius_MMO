package net.raeen.aetheriusmod.pvp;

import net.minecraft.server.level.ServerPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DuelManager {
    private final Map<UUID, Duel> activeDuels = new HashMap<>();

    public void startDuel(ServerPlayer player1, ServerPlayer player2) {
        Duel duel = new Duel(player1, player2);
        activeDuels.put(player1.getUUID(), duel);
        activeDuels.put(player2.getUUID(), duel);
    }

    public Duel getDuel(UUID playerId) {
        return activeDuels.get(playerId);
    }

    public void endDuel(ServerPlayer player1, ServerPlayer player2) {
        Duel duel = activeDuels.get(player1.getUUID());
        if (duel != null) {
            duel.endDuel();
            activeDuels.remove(player1.getUUID());
            activeDuels.remove(player2.getUUID());
        }
    }
}
