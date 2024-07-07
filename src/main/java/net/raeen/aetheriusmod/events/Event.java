package net.raeen.aetheriusmod.events;

public class Event {
    private final String name;
    private final String description;
    private final int reward;

    public Event(String name, String description, int reward) {
        this.name = name;
        this.description = description;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getReward() {
        return reward;
    }
}
