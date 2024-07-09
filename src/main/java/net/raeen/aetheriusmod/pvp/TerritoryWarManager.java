package net.raeen.aetheriusmod.pvp;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TerritoryWarManager {
    private final Map<UUID, TerritoryWar> activeWars = new HashMap<>();

    public void startWar(UUID attackingGuild, UUID defendingGuild) {
        TerritoryWar war = new TerritoryWar(attackingGuild, defendingGuild);
        activeWars.put(attackingGuild, war);
        activeWars.put(defendingGuild, war);
    }

    public TerritoryWar getWar(UUID guildId) {
        return activeWars.get(guildId);
    }

    public void endWar(UUID attackingGuild, UUID defendingGuild) {
        TerritoryWar war = activeWars.get(attackingGuild);
        if (war != null) {
            war.endWar();
            activeWars.remove(attackingGuild);
            activeWars.remove(defendingGuild);
        }
    }
}
