package net.raeen.aetheriusmod.multiplayer;

import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Party {
    private final UUID leader;
    private final List<UUID> members = new ArrayList<>();

    public Party(Player leader) {
        this.leader = leader.getUUID();
        members.add(leader.getUUID());
    }

    public UUID getLeader() {
        return leader;
    }

    public List<UUID> getMembers() {
        return members;
    }

    public void addMember(Player player) {
        if (!members.contains(player.getUUID())) {
            members.add(player.getUUID());
        }
    }

    public void removeMember(Player player) {
        members.remove(player.getUUID());
    }

    public void disband() {
        members.clear();
    }
}
