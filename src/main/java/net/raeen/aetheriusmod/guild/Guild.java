package net.raeen.aetheriusmod.guild;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Guild {
    private UUID guildId;
    private String name;
    private Map<UUID, String> members; // UUID to Role

    public Guild(UUID guildId, String name) {
        this.guildId = guildId;
        this.name = name;
        this.members = new HashMap<>();
    }

    public UUID getGuildId() {
        return guildId;
    }

    public String getName() {
        return name;
    }

    public Map<UUID, String> getMembers() {
        return members;
    }

    public void addMember(UUID playerId, String role) {
        members.put(playerId, role);
    }

    public void removeMember(UUID playerId) {
        members.remove(playerId);
    }

    public boolean isLeader(UUID playerId) {
        return "Leader".equals(members.get(playerId));
    }
}
