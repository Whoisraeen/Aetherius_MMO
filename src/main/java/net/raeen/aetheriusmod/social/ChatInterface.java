package net.raeen.aetheriusmod.social;

import java.util.ArrayList;
import java.util.List;

public class ChatInterface {
    private final List<String> chatLog;
    private final List<String> proximityChat;
    private final List<String> whisperChat;
    private final List<String> squadChat;
    private final List<String> guildChat;
    private final List<String> worldChat;

    public ChatInterface() {
        this.chatLog = new ArrayList<>();
        this.proximityChat = new ArrayList<>();
        this.whisperChat = new ArrayList<>();
        this.squadChat = new ArrayList<>();
        this.guildChat = new ArrayList<>();
        this.worldChat = new ArrayList<>();
    }

    public void addMessage(String message, String chatType) {
        chatLog.add(message);
        switch (chatType) {
            case "Proximity":
                proximityChat.add(message);
                break;
            case "Whisper":
                whisperChat.add(message);
                break;
            case "Squad":
                squadChat.add(message);
                break;
            case "Guild":
                guildChat.add(message);
                break;
            case "World":
                worldChat.add(message);
                break;
        }
    }

    public List<String> getChatLog() {
        return chatLog;
    }

    public List<String> getProximityChat() {
        return proximityChat;
    }

    public List<String> getWhisperChat() {
        return whisperChat;
    }

    public List<String> getSquadChat() {
        return squadChat;
    }

    public List<String> getGuildChat() {
        return guildChat;
    }

    public List<String> getWorldChat() {
        return worldChat;
    }
}
