package net.raeen.aetheriusmod.hotbar;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HotbarManager {
    private final Map<UUID, Hotbar> hotbars = new HashMap<>();

    public Hotbar getHotbar(UUID playerId) {
        return hotbars.getOrDefault(playerId, new Hotbar(/*default items*/));
    }

    public void setHotbar(UUID playerId, Hotbar hotbar) {
        hotbars.put(playerId, hotbar);
    }
}
