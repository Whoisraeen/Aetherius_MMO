package net.raeen.aetheriusmod.progression;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TitleManager {
    private final Map<UUID, PlayerProgression> playerProgressions;

    public TitleManager(Map<UUID, PlayerProgression> playerProgressions) {
        this.playerProgressions = playerProgressions;
    }

    public void awardTitle(UUID playerId, Title title) {
        PlayerProgression progression = playerProgressions.get(playerId);
        if (progression != null) {
            progression.addTitle(title);
        }
    }
}
