package net.raeen.aetheriusmod.items;

import java.util.HashMap;
import java.util.Map;

public class GatheringSystem {
    private final Map<String, String[]> gatherableResources;

    public GatheringSystem() {
        this.gatherableResources = new HashMap<>();
        initializeResources();
    }

    private void initializeResources() {
        gatherableResources.put("Forest", new String[]{"Wood", "Herbs"});
        gatherableResources.put("Mountain", new String[]{"Ore", "Stone"});
        // Add more resources
    }

    public String[] gatherResources(String location) {
        return gatherableResources.getOrDefault(location, new String[]{});
    }
}
