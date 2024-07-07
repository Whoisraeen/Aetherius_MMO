package net.raeen.aetheriusmod.biomes;

import net.raeen.aetheriusmod.mobs.Mob;
import net.raeen.aetheriusmod.mobs.MobRegistry;

import java.util.ArrayList;
import java.util.List;

public class BiomeRegistry {
    private final List<Biome> biomes;

    public BiomeRegistry(MobRegistry mobRegistry) {
        this.biomes = new ArrayList<>();
        initializeBiomes(mobRegistry);
    }

    private void initializeBiomes(MobRegistry mobRegistry) {
        List<Mob> forestMobs = mobRegistry.getMobsByBiome("Forest");
        List<Mob> mountainMobs = mobRegistry.getMobsByBiome("Mountain");

        biomes.add(new Biome("Forest", forestMobs));
        biomes.add(new Biome("Mountain", mountainMobs));
        // Add more biomes
    }

    public List<Biome> getBiomes() {
        return biomes;
    }
}
