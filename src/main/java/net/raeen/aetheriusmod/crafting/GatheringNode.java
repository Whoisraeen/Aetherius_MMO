package net.raeen.aetheriusmod.crafting;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;

public class GatheringNode {
    private final String name;
    private final BlockPos position;
    private final ItemStack drop;

    public GatheringNode(String name, BlockPos position, ItemStack drop) {
        this.name = name;
        this.position = position;
        this.drop = drop;
    }

    public String getName() {
        return name;
    }

    public BlockPos getPosition() {
        return position;
    }

    public ItemStack getDrop() {
        return drop;
    }

    public void gather(ServerLevel world) {
        // Logic for gathering resources from the node
    }
}
