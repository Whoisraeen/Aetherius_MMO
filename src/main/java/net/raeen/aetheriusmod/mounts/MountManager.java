package net.raeen.aetheriusmod.mounts;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MountManager {
    private final Map<UUID, Mount> mounts = new HashMap<>();

    public Mount getMount(UUID playerId) {
        return mounts.get(playerId);
    }

    public void addMount(UUID playerId, Mount mount) {
        mounts.put(playerId, mount);
    }
}
