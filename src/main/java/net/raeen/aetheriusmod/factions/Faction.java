package net.raeen.aetheriusmod.factions;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Faction {
    private String name;
    private Map<UUID, String> members; // UUID to Role

    public Faction(String name) {
        this.name = name;
        this.members = new HashMap<>();
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
