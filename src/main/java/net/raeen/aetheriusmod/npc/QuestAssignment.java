package net.raeen.aetheriusmod.npc;

import net.minecraft.server.level.ServerPlayer;
import net.raeen.aetheriusmod.quests.Quest;
import net.raeen.aetheriusmod.quests.QuestManager;

import java.util.UUID;

public class QuestAssignment {
    private final QuestManager questManager;
    private final NPCManager npcManager;

    public QuestAssignment(QuestManager questManager, NPCManager npcManager) {
        this.questManager = questManager;
        this.npcManager = npcManager;
    }

    public void assignQuest(ServerPlayer player, UUID npcId, Quest quest) {
        npcManager.assignQuestToNPC(npcId, quest);
        questManager.assignQuest(player, quest);
    }

    public void completeQuest(ServerPlayer player, Quest quest) {
        questManager.completeQuest(player, quest);
    }
}
