package net.raeen.aetheriusmod.dungeons;

import net.raeen.aetheriusmod.character.GameCharacter;

import java.util.ArrayList;
import java.util.List;

public class DungeonManager {
    private final List<DungeonInstance> dungeons;

    public DungeonManager() {
        this.dungeons = new ArrayList<>();
        initializeDungeons();
    }

    private void initializeDungeons() {
        dungeons.add(new DungeonInstance("Goblin Cave"));
        dungeons.add(new DungeonInstance("Troll Den"));
        // Add more dungeons
    }

    public DungeonInstance createDungeonInstance(String dungeonName, List<GameCharacter> participants) {
        DungeonInstance newInstance = new DungeonInstance(dungeonName);
        for (GameCharacter participant : participants) {
            newInstance.addParticipant(participant);
        }
        dungeons.add(newInstance);
        return newInstance;
    }

    public List<DungeonInstance> getDungeons() {
        return dungeons;
    }
}
