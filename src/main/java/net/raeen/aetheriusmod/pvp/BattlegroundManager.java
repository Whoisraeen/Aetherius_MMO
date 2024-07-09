package net.raeen.aetheriusmod.pvp;

import net.minecraft.server.level.ServerPlayer;
import java.util.ArrayList;
import java.util.List;

public class BattlegroundManager {
    private final List<Battleground> activeBattlegrounds = new ArrayList<>();

    public void startBattleground(List<ServerPlayer> team1, List<ServerPlayer> team2) {
        Battleground battleground = new Battleground(team1, team2);
        activeBattlegrounds.add(battleground);
    }

    public void endBattleground(Battleground battleground) {
        battleground.endBattleground();
        activeBattlegrounds.remove(battleground);
    }

    public List<Battleground> getActiveBattlegrounds() {
        return activeBattlegrounds;
    }
}
