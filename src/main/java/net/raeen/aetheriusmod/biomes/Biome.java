package net.raeen.aetheriusmod.biomes;

import net.raeen.aetheriusmod.mobs.Mob;

import java.util.List;

public class Biome {
    private final String name;
    private final List<Mob> mobs;

    public Biome(String name, List<Mob> mobs) {
        this.name = name;
        this.mobs = mobs;
    }

    public String getName() {
        return name;
    }

    public List<Mob> getMobs() {
        return mobs;
    }
}
