package net.raeen.aetheriusmod.social;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PartyManager {
    private final Map<UUID, Party> parties;

    public PartyManager() {
        this.parties = new HashMap<>();
    }

    public Party createParty(UUID leader) {
        Party party = new Party(leader);
        parties.put(leader, party);
        return party;
    }

    public void disbandParty(UUID leader) {
        parties.remove(leader);
    }

    public Party getParty(UUID player) {
        return parties.values().stream()
                .filter(party -> party.isMember(player))
                .findFirst()
                .orElse(null);
    }

    public void invitePlayer(UUID leader, UUID player) {
        Party party = parties.get(leader);
        if (party != null) {
            party.invitePlayer(player);
        }
    }

    public void acceptInvite(UUID player) {
        parties.values().forEach(party -> party.acceptInvite(player));
    }

    public void declineInvite(UUID player) {
        parties.values().forEach(party -> party.declineInvite(player));
    }
}
