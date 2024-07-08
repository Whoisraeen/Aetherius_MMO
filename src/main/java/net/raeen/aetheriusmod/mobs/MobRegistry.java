package net.raeen.aetheriusmod.mobs;

import java.util.ArrayList;
import java.util.List;

public class MobRegistry {
    private final List<Mob> mobs;

    public MobRegistry() {
        this.mobs = new ArrayList<>();
        // Register mobs
    }

    public void registerMob(Mob mob) {
        this.mobs.add(mob);
    }

    public List<Mob> getMobs() {
        return mobs;
    }

    // Example mob
    public class Goblin extends Mob {
        public Goblin() {
            super("Goblin", 50);
        }
    }
}
