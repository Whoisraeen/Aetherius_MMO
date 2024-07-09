package net.raeen.aetheriusmod.npc;

import net.minecraft.server.level.ServerPlayer;
import net.raeen.aetheriusmod.quests.Quest;

import java.util.List;

public class NPC {
    private String name;
    private String race;
    private String city;
    private List<String> dialogues;
    private List<Quest> quests;

    public NPC(String name, String race, String city, List<String> dialogues, List<Quest> quests) {
        this.name = name;
        this.race = race;
        this.city = city;
        this.dialogues = dialogues;
        this.quests = quests;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getCity() {
        return city;
    }

    public List<String> getDialogues() {
        return dialogues;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void interact(ServerPlayer player) {
        // Handle interaction logic
    }
}
