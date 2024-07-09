package net.raeen.aetheriusmod.dungeons;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

public class DungeonRoom {
    private final String name;
    private final BlockPos position;

    public DungeonRoom(String name, BlockPos position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public BlockPos getPosition() {
        return position;
    }

    public void generate(ServerLevel world) {
        // Logic to generate the room layout in the world
    }
}
