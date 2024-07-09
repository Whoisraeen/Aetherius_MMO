package net.raeen.aetheriusmod.multiplayer;

import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PartyManager {
    private final Map<UUID, Party> parties = new HashMap<>();

    public void createParty(ServerPlayer leader) {
        Party party = new Party(leader);
        parties.put(leader.getUUID(), party);
    }

    public void addMember(ServerPlayer leader, ServerPlayer newMember) {
        Party party = parties.get(leader.getUUID());
        if (party != null) {
            party.addMember(newMember);
        }
    }

    public void removeMember(ServerPlayer leader, ServerPlayer member) {
        Party party = parties.get(leader.getUUID());
        if (party != null) {
            party.removeMember(member);
        }
    }

    public void disbandParty(ServerPlayer leader) {
        Party party = parties.get(leader.getUUID());
        if (party != null) {
            party.disband();
            parties.remove(leader.getUUID());
        }
    }

    public Party getParty(UUID leaderId) {
        return parties.get(leaderId);
    }
}
