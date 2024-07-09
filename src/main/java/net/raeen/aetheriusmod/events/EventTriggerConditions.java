package net.raeen.aetheriusmod.events;

import net.minecraft.world.entity.player.Player;

import java.util.List;

public class EventTriggerConditions {
    private final EventTrigger eventTrigger;

    public EventTriggerConditions(EventTrigger eventTrigger) {
        this.eventTrigger = eventTrigger;
    }

    public void triggerEventIfConditionMet(String name, String description, long startTime, long endTime, List<Player> participants) {
        // Example condition: trigger event if there are more than 5 players online
        if (participants.size() > 5) {
            eventTrigger.triggerEvent(name, description, startTime, endTime, participants);
        }
    }
}
