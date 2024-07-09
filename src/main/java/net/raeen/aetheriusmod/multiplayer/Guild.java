package net.raeen.aetheriusmod.multiplayer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Guild {
    private final UUID guildId;
    private final String name;
    private final UUID leader;
    private final List<UUID> members = new ArrayList<>();

    public Guild(UUID leader, String name) {
        this.guildId = UUID.randomUUID();
        this.leader = leader;
        this.name = name;
        members.add(leader);
    }

    public UUID getGuildId() {
        return guildId;
    }

    public String getName() {
        return name;
    }

    public UUID getLeader() {
        return leader;
    }

    public List<UUID> getMembers() {
        return members;
    }

    public void addMember(UUID member) {
        members.add(member);
    }

    public void removeMember(UUID member) {
        members.remove(member);
    }
}
