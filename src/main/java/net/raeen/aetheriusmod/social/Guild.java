package net.raeen.aetheriusmod.social;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private final String name;
    private final List<String> members;
    private final List<String> roles;

    public Guild(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.roles = new ArrayList<>();
    }

    public void addMember(String playerName) {
        this.members.add(playerName);
    }

    public void removeMember(String playerName) {
        this.members.remove(playerName);
    }

    public void assignRole(String playerName, String role) {
        if (members.contains(playerName)) {
            roles.add(role);
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getMembers() {
        return members;
    }

    public List<String> getRoles() {
        return roles;
    }

    // Additional guild management methods
}
