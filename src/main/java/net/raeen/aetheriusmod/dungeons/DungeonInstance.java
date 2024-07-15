package net.raeen.aetheriusmod.dungeons;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.UUID;

public class DungeonInstance {
    private final UUID instanceId;
    private final String name;
    private final ServerLevel world;
    private final BlockPos entryPoint;
    private final List<Player> players;
    private final DungeonFloor[] floors;

    public DungeonInstance(String name, ServerLevel world, BlockPos entryPoint, List<Player> players, DungeonFloor[] floors) {
        this.instanceId = UUID.randomUUID();
        this.name = name;
        this.world = world;
        this.entryPoint = entryPoint;
        this.players = players;
        this.floors = floors;
    }

    public UUID getInstanceId() {
        return instanceId;
    }

    public String getName() {
        return name;
    }

    public ServerLevel getWorld() {
        return world;
    }

    public BlockPos getEntryPoint() {
        return entryPoint;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public DungeonFloor[] getFloors() {
        return floors;
    }
}
