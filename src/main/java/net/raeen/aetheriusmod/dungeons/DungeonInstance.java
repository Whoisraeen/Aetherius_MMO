package net.raeen.aetheriusmod.dungeons;

import net.raeen.aetheriusmod.character.GameCharacter;

import java.util.ArrayList;
import java.util.List;

public class DungeonInstance {
    private final String name;
    private final List<GameCharacter> participants;

    public DungeonInstance(String name) {
        this.name = name;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(GameCharacter character) {
        participants.add(character);
    }

    public List<GameCharacter> getParticipants() {
        return participants;
    }

    public String getName() {
        return name;
    }
}
