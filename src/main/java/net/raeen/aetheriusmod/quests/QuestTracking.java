package net.raeen.aetheriusmod.quests;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

public class QuestTracking {
    private final QuestManager questManager;

    public QuestTracking(QuestManager questManager) {
        this.questManager = questManager;
    }

    public void displayActiveQuests(ServerPlayer player) {
        questManager.getActiveQuests().forEach((uuid, quest) -> {
            player.sendSystemMessage(Component.literal("Active Quest: " + quest.getName() + " - " + quest.getDescription()));
        });
    }

    public void displayCompletedQuests(ServerPlayer player) {
        questManager.getCompletedQuests().forEach((uuid, quest) -> {
            player.sendSystemMessage(Component.literal("Completed Quest: " + quest.getName() + " - " + quest.getDescription()));
        });
    }
}
