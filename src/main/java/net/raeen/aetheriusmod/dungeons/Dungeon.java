package net.raeen.aetheriusmod.dungeons;

import net.minecraft.core.BlockPos;

public class Dungeon {
    private final BlockPos entrance;
    private final String name;
    private final String layout;

    public Dungeon(String name, String layout, BlockPos entrance) {
        this.name = name;
        this.layout = layout;
        this.entrance = entrance;
    }

    public BlockPos getEntrance() {
        return entrance;
    }

    public String getName() {
        return name;
    }

    public String getLayout() {
        return layout;
    }
}
