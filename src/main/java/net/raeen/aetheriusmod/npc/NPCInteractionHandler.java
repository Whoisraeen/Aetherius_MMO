package net.raeen.aetheriusmod.npc;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.raeen.aetheriusmod.quests.Quest;

public class NPCInteractionHandler {
    public void interactWithNPC(ServerPlayer player, NPC npc) {
        // Display dialogues
        for (String dialogue : npc.getDialogues()) {
            player.sendSystemMessage(Component.literal(dialogue), false);
        }

        // Assign quests
        for (Quest quest : npc.getQuests()) {
            player.sendSystemMessage(Component.literal("Quest Available: " + quest.getTitle()), false);
            // Logic to accept quest
        }
    }
}
