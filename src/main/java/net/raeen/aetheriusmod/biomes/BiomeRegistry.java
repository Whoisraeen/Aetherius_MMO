package net.raeen.aetheriusmod.biomes;

import net.raeen.aetheriusmod.mobs.MobRegistry;

import java.util.ArrayList;
import java.util.List;

public class BiomeRegistry {
    private final List<Biome> biomes;

    public BiomeRegistry(MobRegistry mobRegistry) {
        this.biomes = new ArrayList<>();
        // Register biomes and assign mobs
    }

    public void registerBiome(Biome biome) {
        this.biomes.add(biome);
    }

    public List<Biome> getBiomes() {
        return biomes;
    }

    // Example biome
    public class Forest extends Biome {
        public Forest() {
            super("Forest", new ArrayList<>());
            // Add mobs to biome
        }
    }
}
