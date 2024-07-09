package net.raeen.aetheriusmod.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventManager {
    private final List<WorldEvent> scheduledEvents = new ArrayList<>();

    public void scheduleEvent(WorldEvent event) {
        scheduledEvents.add(event);
    }

    public List<WorldEvent> getActiveEvents(long currentTime) {
        List<WorldEvent> activeEvents = new ArrayList<>();
        for (WorldEvent event : scheduledEvents) {
            if (currentTime >= event.getStartTime() && currentTime <= event.getEndTime()) {
                activeEvents.add(event);
            }
        }
        return activeEvents;
    }

    public void endEvent(UUID eventId) {
        scheduledEvents.removeIf(event -> event.getEventId().equals(eventId));
    }

    public void distributeRewards(WorldEvent event) {
        // Logic to distribute rewards to participants
        for (Player player : event.getParticipants()) {
            // Example reward: give experience points
            player.giveExperiencePoints(100);
        }
    }
}
