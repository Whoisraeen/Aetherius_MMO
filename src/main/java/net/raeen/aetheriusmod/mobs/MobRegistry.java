package net.raeen.aetheriusmod.mobs;

import java.util.ArrayList;
import java.util.List;

public class MobRegistry {
    private final List<Mob> mobs;

    public MobRegistry() {
        this.mobs = new ArrayList<>();
        initializeMobs();
    }

    private void initializeMobs() {
        mobs.add(new Mob("Goblin", 20, 5, "Forest"));
        mobs.add(new Mob("Troll", 50, 10, "Mountain"));
        // Add more mobs
    }

    public List<Mob> getMobs() {
        return mobs;
    }

    public List<Mob> getMobsByBiome(String biome) {
        List<Mob> mobsInBiome = new ArrayList<>();
        for (Mob mob : mobs) {
            if (mob.getBiome().equals(biome)) {
                mobsInBiome.add(mob);
            }
        }
        return mobsInBiome;
    }
}
