package net.raeen.aetheriusmod.territory;

import net.raeen.aetheriusmod.guild.GuildManager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TerritoryManager {
    private final Map<String, Territory> territories = new HashMap<>();
    private final GuildManager guildManager;

    public TerritoryManager(GuildManager guildManager) {
        this.guildManager = guildManager;
    }

    public Territory getTerritory(String name) {
        return territories.get(name);
    }

    public void startWar(String territoryName, UUID attackingGuild, UUID defendingGuild) {
        Territory territory = territories.get(territoryName);
        War war = new War(attackingGuild, defendingGuild, territoryName);
        // Logic to handle war start
    }

    public void endWar(String territoryName, UUID winningGuild) {
        Territory territory = territories.get(territoryName);
        territory.setControllingGuild(winningGuild);
        // Logic to handle war end and rewards
    }

    public void captureTerritory(UUID guildId, String territoryName) {
        Territory territory = territories.get(territoryName);
        territory.setControllingGuild(guildId);
    }

    public void contestTerritory(UUID guildId, String territoryName) {
        Territory territory = territories.get(territoryName);
        territory.setContestingGuild(guildId);
    }
}
