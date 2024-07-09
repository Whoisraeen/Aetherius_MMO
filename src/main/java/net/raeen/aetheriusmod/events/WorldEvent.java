package net.raeen.aetheriusmod.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.UUID;

public class WorldEvent {
    private final UUID eventId;
    private final String name;
    private final String description;
    private final long startTime;
    private final long endTime;
    private final List<Player> participants;

    public WorldEvent(String name, String description, long startTime, long endTime, List<Player> participants) {
        this.eventId = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.participants = participants;
    }

    public UUID getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public List<Player> getParticipants() {
        return participants;
    }
}
