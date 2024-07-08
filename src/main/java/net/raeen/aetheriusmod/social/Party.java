package net.raeen.aetheriusmod.social;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Party {
    private final UUID leader;
    private final List<UUID> members;
    private final List<UUID> invites;

    public Party(UUID leader) {
        this.leader = leader;
        this.members = new ArrayList<>();
        this.invites = new ArrayList<>();
        this.members.add(leader);
    }

    public UUID getLeader() {
        return leader;
    }

    public List<UUID> getMembers() {
        return members;
    }

    public void addMember(UUID player) {
        if (!members.contains(player)) {
            members.add(player);
        }
    }

    public void removeMember(UUID player) {
        members.remove(player);
    }

    public List<UUID> getInvites() {
        return invites;
    }

    public void invitePlayer(UUID player) {
        if (!invites.contains(player)) {
            invites.add(player);
        }
    }

    public void acceptInvite(UUID player) {
        if (invites.contains(player)) {
            invites.remove(player);
            addMember(player);
        }
    }

    public void declineInvite(UUID player) {
        invites.remove(player);
    }

    public boolean isLeader(UUID player) {
        return leader.equals(player);
    }

    public boolean isMember(UUID player) {
        return members.contains(player);
    }
}
