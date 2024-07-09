package net.raeen.aetheriusmod.factions;

import net.minecraft.server.level.ServerPlayer;
import net.raeen.aetheriusmod.rewards.Rewards;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FactionQuestManager {
    private final Map<UUID, FactionQuest> activeFactionQuests = new HashMap<>();

    public void assignFactionQuest(ServerPlayer player, FactionQuest quest) {
        activeFactionQuests.put(player.getUUID(), quest);
    }

    public FactionQuest getFactionQuest(UUID playerId) {
        return activeFactionQuests.get(playerId);
    }

    public void completeFactionQuest(ServerPlayer player) {
        UUID playerId = player.getUUID();
        if (activeFactionQuests.containsKey(playerId)) {
            FactionQuest quest = activeFactionQuests.remove(playerId);
            Rewards.giveFactionQuestReward(player, quest.getReward());
        }
    }
}
