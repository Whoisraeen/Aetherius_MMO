package net.raeen.aetheriusmod.multiplayer;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.raeen.aetheriusmod.multiplayer.ChatChannel;
import net.raeen.aetheriusmod.multiplayer.ChatMessage;
import net.raeen.aetheriusmod.multiplayer.ChatSystem;

public class ChatSystemManager {
    private final ChatSystem chatSystem = new ChatSystem();

    public void sendMessage(ServerPlayer sender, String message, ChatChannel channel) {
        ChatMessage chatMessage = new ChatMessage(sender.getUUID(), message, channel);
        chatSystem.addMessage(chatMessage);
    }

    public void displayMessages(ServerPlayer player, ChatChannel channel) {
        for (ChatMessage message : chatSystem.getMessagesByChannel(channel)) {
            player.sendSystemMessage(Component.literal(message.getMessage()), false);
        }
    }
}
