package net.raeen.aetheriusmod.multiplayer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChatSystem {
    private final List<ChatMessage> messages = new ArrayList<>();

    public void addMessage(ChatMessage message) {
        messages.add(message);
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public List<ChatMessage> getMessagesByChannel(ChatChannel channel) {
        List<ChatMessage> channelMessages = new ArrayList<>();
        for (ChatMessage message : messages) {
            if (message.getChannel() == channel) {
                channelMessages.add(message);
            }
        }
        return channelMessages;
    }
}

enum ChatChannel {
    LOCAL,
    PRIVATE,
    PARTY,
    GUILD,
    WORLD
}

class ChatMessage {
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
