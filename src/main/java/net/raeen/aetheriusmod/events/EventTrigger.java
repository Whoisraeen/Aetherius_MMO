package net.raeen.aetheriusmod.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class EventTrigger {
    private final EventManager eventManager;

    public EventTrigger(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public void triggerEvent(String name, String description, long startTime, long endTime, List<Player> participants) {
        WorldEvent event = new WorldEvent(name, description, startTime, endTime, participants);
        eventManager.scheduleEvent(event);
    }

    public void checkAndEndEvents(long currentTime) {
        List<WorldEvent> activeEvents = eventManager.getActiveEvents(currentTime);
        for (WorldEvent event : activeEvents) {
            if (currentTime > event.getEndTime()) {
                eventManager.endEvent(event.getEventId());
                eventManager.distributeRewards(event);
            }
        }
    }
}
