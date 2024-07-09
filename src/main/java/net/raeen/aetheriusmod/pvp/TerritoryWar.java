package net.raeen.aetheriusmod.pvp;

import java.util.UUID;

public class TerritoryWar {
    private final UUID attackingGuild;
    private final UUID defendingGuild;
    private boolean active;

    public TerritoryWar(UUID attackingGuild, UUID defendingGuild) {
        this.attackingGuild = attackingGuild;
        this.defendingGuild = defendingGuild;
        this.active = true;
    }

    public UUID getAttackingGuild() {
        return attackingGuild;
    }

    public UUID getDefendingGuild() {
        return defendingGuild;
    }

    public boolean isActive() {
        return active;
    }

    public void endWar() {
        this.active = false;
    }
}
