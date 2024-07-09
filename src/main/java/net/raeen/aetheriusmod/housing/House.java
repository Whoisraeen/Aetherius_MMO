package net.raeen.aetheriusmod.housing;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class House {
    private UUID owner;
    private BlockPos location;
    private Map<BlockPos, BlockState> blocks;

    public House(UUID owner, BlockPos location) {
        this.owner = owner;
        this.location = location;
        this.blocks = new HashMap<>();
    }

    public UUID getOwner() {
        return owner;
    }

    public BlockPos getLocation() {
        return location;
    }

    public Map<BlockPos, BlockState> getBlocks() {
        return blocks;
    }

    public void setBlock(BlockPos pos, BlockState state) {
        blocks.put(pos, state);
    }
}
