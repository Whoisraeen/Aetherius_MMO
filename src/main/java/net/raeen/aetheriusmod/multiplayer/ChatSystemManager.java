package net.raeen.aetheriusmod.multiplayer;

import net.minecraft.server.level.ServerPlayer;

import java.util.UUID;

public class ChatSystemManager {
    private final ChatSystem chatSystem = new ChatSystem();

    public void sendMessage(ServerPlayer sender, String message, ChatChannel channel) {
        ChatMessage chatMessage = new ChatMessage(sender.getUUID(), message, channel);
        chatSystem.addMessage(chatMessage);
    }

    public void displayMessages(ServerPlayer player, ChatChannel channel) {
        for (ChatMessage message : chatSystem.getMessagesByChannel(channel)) {
            player.sendMessage(Component.literal(message.getMessage()));
        }
    }
}
