package net.raeen.aetheriusmod.npc;

import net.raeen.aetheriusmod.quests.Quest;

import java.util.UUID;

public class NPC {
    private final UUID id;
    private final String name;
    private Quest quest;
    private int posX, posY, posZ; // Assuming position is stored as coordinates
    private Quest[] quests; // Assuming NPC can have multiple quests

    public NPC(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean hasQuest() {
        return quest != null;
    }

    public Quest getQuest() {
        return quest;
    }

    public void assignQuest(Quest quest) {
        this.quest = quest;
    }

    public UUID getUUID() {
        return id;
    }

    public void setPos(int x, int y, int z) {
        this.posX = x;
        this.posY = y;
        this.posZ = z;
    }

    public Quest[] getQuests() {
        return quests;
    }

    public void setQuests(Quest[] quests) {
        this.quests = quests;
    }
}
