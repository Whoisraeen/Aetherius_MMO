package net.raeen.aetheriusmod.quests;

import net.minecraft.server.level.ServerPlayer;

public class DynamicInteractionManager {
    private final QuestManager questManager;

    public DynamicInteractionManager(QuestManager questManager) {
        this.questManager = questManager;
    }

    public void interactWithNPC(ServerPlayer player, NPC npc) {
        if (npc.hasQuest()) {
            questManager.assignQuest(player, npc.getQuest());
        }
    }

    public void updateQuestProgress(ServerPlayer player, QuestObjective objective) {
        questManager.updateQuestProgress(player, objective);
    }
}
