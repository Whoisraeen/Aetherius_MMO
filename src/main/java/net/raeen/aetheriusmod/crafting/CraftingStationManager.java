package net.raeen.aetheriusmod.crafting;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import java.util.HashMap;
import java.util.Map;

public class CraftingStationManager {
    private final Map<String, CraftingStation> stations = new HashMap<>();

    public void addCraftingStation(CraftingStation station) {
        stations.put(station.getName(), station);
    }

    public CraftingStation getCraftingStation(String name) {
        return stations.get(name);
    }

    public void useCraftingStation(ServerLevel world, String stationName) {
        CraftingStation station = stations.get(stationName);
        if (station != null) {
            station.use(world);
        }
    }
}
