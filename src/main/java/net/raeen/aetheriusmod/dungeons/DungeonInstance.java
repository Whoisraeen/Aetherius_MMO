package net.raeen.aetheriusmod.dungeons;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class DungeonInstance {
    private final String name;
    private final ServerLevel world;
    private final BlockPos entryPoint;
    private final List<Player> players;
    private final DungeonFloor[] floors;

    public DungeonInstance(String name, ServerLevel world, BlockPos entryPoint, List<Player> players, DungeonFloor[] floors) {
        this.name = name;
        this.world = world;
        this.entryPoint = entryPoint;
        this.players = players;
        this.floors = floors;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void start() {
        // Logic to transport players to the dungeon entry point
        for (Player player : players) {
            player.teleportTo(entryPoint.getX(), entryPoint.getY(), entryPoint.getZ());
        }
        // Generate the dungeon floors
        for (DungeonFloor floor : floors) {
            floor.generate(world);
        }
    }
}
