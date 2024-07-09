package net.raeen.aetheriusmod.progression;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AchievementManager {
    private final Map<UUID, PlayerProgression> playerProgressions;

    public AchievementManager(Map<UUID, PlayerProgression> playerProgressions) {
        this.playerProgressions = playerProgressions;
    }

    public void awardAchievement(UUID playerId, Achievement achievement) {
        PlayerProgression progression = playerProgressions.get(playerId);
        if (progression != null) {
            progression.addAchievement(achievement);
        }
    }
}
