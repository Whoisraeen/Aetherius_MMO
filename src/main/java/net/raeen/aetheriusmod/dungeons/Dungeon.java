package net.raeen.aetheriusmod.dungeons;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;

public class Dungeon {
    private final String name;
    private final ResourceLocation layout;
    private final BlockPos entrance;

    public Dungeon(String name, ResourceLocation layout, BlockPos entrance) {
        this.name = name;
        this.layout = layout;
        this.entrance = entrance;
    }

    public String getName() {
        return name;
    }

    public ResourceLocation getLayout() {
        return layout;
    }

    public BlockPos getEntrance() {
        return entrance;
    }
}
