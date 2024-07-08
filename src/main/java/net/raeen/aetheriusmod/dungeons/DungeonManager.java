package net.raeen.aetheriusmod.dungeons;

import net.raeen.aetheriusmod.character.GameCharacter;

import java.util.ArrayList;
import java.util.List;

public class DungeonManager {
    private final List<DungeonInstance> instances;

    public DungeonManager() {
        this.instances = new ArrayList<>();
    }

    public DungeonInstance createDungeonInstance(String name, List<GameCharacter> participants) {
        DungeonInstance instance = new DungeonInstance(name, participants);
        instances.add(instance);
        return instance;
    }

    public List<DungeonInstance> getInstances() {
        return instances;
    }
}
