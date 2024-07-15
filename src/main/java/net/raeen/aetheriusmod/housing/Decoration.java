package net.raeen.aetheriusmod.housing;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;

public class Decoration {
    private final String name;
    private final ItemStack item;
    private BlockPos position; // Remove final if you intend to modify

    public Decoration(String name, ItemStack item, BlockPos position) {
        this.name = name;
        this.item = item;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public ItemStack getItem() {
        return item;
    }

    public BlockPos getPosition() {
        return position;
    }

    public void setPosition(BlockPos position) {
        this.position = position;
    }
}
