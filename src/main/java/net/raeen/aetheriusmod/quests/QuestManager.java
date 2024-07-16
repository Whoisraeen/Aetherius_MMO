package net.raeen.aetheriusmod.quests;

import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QuestManager {
    private final Map<UUID, Quest> activeQuests = new HashMap<>();
    private final Map<UUID, Quest> completedQuests = new HashMap<>();

    public void assignQuest(ServerPlayer player, Quest quest) {
        activeQuests.put(player.getUUID(), quest);
    }

    public void completeQuest(ServerPlayer player, Quest quest) {
        activeQuests.remove(player.getUUID());
        completedQuests.put(player.getUUID(), quest);
    }

    public Map<UUID, Quest> getActiveQuests() {
        return activeQuests;
    }

    public Map<UUID, Quest> getCompletedQuests() {
        return completedQuests;
    }

    public void updateQuestProgress(ServerPlayer player, QuestObjective objective) {

    }

    public void assignDailyQuest(ServerPlayer player, DailyQuest quest) {
    }
}
