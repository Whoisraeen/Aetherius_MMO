package net.raeen.aetheriusmod.pvp;

import net.minecraft.server.level.ServerPlayer;

public class Duel {
    private final ServerPlayer player1;
    private final ServerPlayer player2;
    private boolean active;

    public Duel(ServerPlayer player1, ServerPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.active = true;
    }

    public ServerPlayer getPlayer1() {
        return player1;
    }

    public ServerPlayer getPlayer2() {
        return player2;
    }

    public boolean isActive() {
        return active;
    }

    public void endDuel() {
        this.active = false;
    }
}
