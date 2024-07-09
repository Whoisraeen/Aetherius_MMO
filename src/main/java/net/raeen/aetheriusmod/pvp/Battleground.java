package net.raeen.aetheriusmod.pvp;

import net.minecraft.server.level.ServerPlayer;
import java.util.List;

public class Battleground {
    private final List<ServerPlayer> team1;
    private final List<ServerPlayer> team2;
    private boolean active;

    public Battleground(List<ServerPlayer> team1, List<ServerPlayer> team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.active = true;
    }

    public List<ServerPlayer> getTeam1() {
        return team1;
    }

    public List<ServerPlayer> getTeam2() {
        return team2;
    }

    public boolean isActive() {
        return active;
    }

    public void endBattleground() {
        this.active = false;
    }
}
