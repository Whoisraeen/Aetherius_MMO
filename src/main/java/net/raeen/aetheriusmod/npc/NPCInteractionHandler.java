package net.raeen.aetheriusmod.npc;

public class NPCInteractionHandler {
    public void interactWithNPC(ServerPlayer player, NPC npc) {
        // Display dialogues
        for (String dialogue : npc.getDialogues()) {
            player.sendMessage(new TextComponent(dialogue), player.getUUID());
        }

        // Assign quests
        for (Quest quest : npc.getQuests()) {
            player.sendMessage(new TextComponent("Quest Available: " + quest.getTitle()), player.getUUID());
            // Logic to accept quest
        }
    }
}

