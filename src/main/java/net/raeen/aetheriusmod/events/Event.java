package net.raeen.aetheriusmod.events;

import java.util.Date;

public class Event {
    private String name;
    private String description;
    private Date startTime;
    private Date endTime;
    private int reward;

    public Event(String name, String description, Date startTime, Date endTime, int reward) {
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getReward() {
        return reward;
    }
}
