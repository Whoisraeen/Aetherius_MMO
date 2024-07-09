package net.raeen.aetheriusmod.territory;

import java.util.UUID;

public class War {
    private UUID attackingGuild;
    private UUID defendingGuild;
    private String territoryName;
    private boolean isActive;

    public War(UUID attackingGuild, UUID defendingGuild, String territoryName) {
        this.attackingGuild = attackingGuild;
        this.defendingGuild = defendingGuild;
        this.territoryName = territoryName;
        this.isActive = true;
    }

    public UUID getAttackingGuild() {
        return attackingGuild;
    }

    public UUID getDefendingGuild() {
        return defendingGuild;
    }

    public String getTerritoryName() {
        return territoryName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void endWar(UUID winningGuild) {
        this.isActive = false;
        // Logic to set the territory control to the winning guild
    }
}
