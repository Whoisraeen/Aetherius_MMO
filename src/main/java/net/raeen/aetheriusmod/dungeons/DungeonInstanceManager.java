package net.raeen.aetheriusmod.dungeons;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.UUID;

public class DungeonInstanceManager {
    private final DungeonManager dungeonManager;

    public DungeonInstanceManager(DungeonManager dungeonManager) {
        this.dungeonManager = dungeonManager;
    }

    public DungeonInstance createInstance(String dungeonName, ServerLevel world, List<Player> participants) {
        return dungeonManager.createInstance(dungeonName, world, participants);
    }

    public DungeonInstance getInstance(UUID instanceId) {
        return dungeonManager.getInstance(instanceId);
    }
}
