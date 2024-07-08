package net.raeen.aetheriusmod.dungeons;

import net.raeen.aetheriusmod.character.GameCharacter;

import java.util.List;

public class DungeonInstance {
    private final String name;
    private final List<GameCharacter> participants;

    public DungeonInstance(String name, List<GameCharacter> participants) {
        this.name = name;
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public List<GameCharacter> getParticipants() {
        return participants;
    }
}

