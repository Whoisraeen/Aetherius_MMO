package net.raeen.aetheriusmod.crafting;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

public class CraftingStation {
    private final String name;
    private final BlockPos position;

    public CraftingStation(String name, BlockPos position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public BlockPos getPosition() {
        return position;
    }

    public void use(ServerLevel world) {
        // Logic for using the crafting station
    }
}
