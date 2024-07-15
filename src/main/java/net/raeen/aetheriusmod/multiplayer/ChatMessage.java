package net.raeen.aetheriusmod.multiplayer;

import java.util.UUID;

public class ChatMessage {
    private final UUID sender;
    private final String message;
    private final ChatChannel channel;

    public ChatMessage(UUID sender, String message, ChatChannel channel) {
        this.sender = sender;
        this.message = message;
        this.channel = channel;
    }

    public UUID getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public ChatChannel getChannel() {
        return channel;
    }
}
