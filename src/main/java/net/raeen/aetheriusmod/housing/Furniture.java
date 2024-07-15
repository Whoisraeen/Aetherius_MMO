package net.raeen.aetheriusmod.housing;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;

public class Furniture {
    private final String name;
    private final ItemStack item;
    private BlockPos position;

    public Furniture(String name, ItemStack item, BlockPos position) {
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

    // Example of using the setPosition method
    public void moveFurniture(BlockPos newPosition) {
        this.setPosition(newPosition);
    }
}
