package net.raeen.aetheriusmod.economy;

import java.util.Map;

public class EconomyManager {
    private Map<String, Integer> playerBalances;

    public void addPlayer(String playerName) {
        playerBalances.put(playerName, 0);
    }

    public void updateBalance(String playerName, int amount) {
        int balance = playerBalances.get(playerName) + amount;
        playerBalances.put(playerName, balance);
    }

    public int getBalance(String playerName) {
        return playerBalances.get(playerName);
    }
}
