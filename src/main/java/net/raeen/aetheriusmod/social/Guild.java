package net.raeen.aetheriusmod.social;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private final String name;
    private final List<String> members;

    public Guild(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void addMember(String playerName) {
        members.add(playerName);
    }

    public void removeMember(String playerName) {
        members.remove(playerName);
    }

    public List<String> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }
}
