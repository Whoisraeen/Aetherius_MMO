package net.raeen.aetheriusmod.quests;

import net.raeen.aetheriusmod.classes.GameCharacter;

import java.util.List;

public class EscortQuest extends Quest {
    private final GameCharacter npcToEscort;
    private final String destination;

    public EscortQuest(String name, String description, List<String> objectives, int experienceReward, List<String> itemRewards, int currencyReward, GameCharacter npcToEscort, String destination) {
        super(name, description, objectives, experienceReward, itemRewards, currencyReward);
        this.npcToEscort = npcToEscort;
        this.destination = destination;
    }

    public GameCharacter getNpcToEscort() {
        return npcToEscort;
    }

    public String getDestination() {
        return destination;
    }
}
