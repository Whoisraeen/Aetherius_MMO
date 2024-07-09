package net.raeen.aetheriusmod.territory;

import java.util.UUID;

public class Territory {
    private String name;
    private UUID controllingGuild;
    private UUID contestingGuild;

    public Territory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getControllingGuild() {
        return controllingGuild;
    }

    public void setControllingGuild(UUID controllingGuild) {
        this.controllingGuild = controllingGuild;
    }

    public UUID getContestingGuild() {
        return contestingGuild;
    }

    public void setContestingGuild(UUID contestingGuild) {
        this.contestingGuild = contestingGuild;
    }
}
