package net.raeen.aetheriusmod.economy;

import java.util.HashMap;
import java.util.Map;

public class EconomySystem {
    private final Map<String, Integer> playerBalances;

    public EconomySystem() {
        this.playerBalances = new HashMap<>();
    }

    public void addPlayer(String playerName) {
        playerBalances.put(playerName, 100); // Initial balance
    }

    public void updateBalance(String playerName, int amount) {
        playerBalances.put(playerName, playerBalances.getOrDefault(playerName, 0) + amount);
    }

    public int getBalance(String playerName) {
        return playerBalances.getOrDefault(playerName, 0);
    }
}
