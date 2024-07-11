package net.raeen.aetheriusmod.economy;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Economy {
    private final Map<UUID, Double> playerBalances = new HashMap<>();

    public void createAccount(UUID playerId) {
        playerBalances.put(playerId, 0.0);
    }

    public double getBalance(UUID playerId) {
        return playerBalances.getOrDefault(playerId, 0.0);
    }

    public void deposit(UUID playerId, double amount) {
        playerBalances.put(playerId, getBalance(playerId) + amount);
    }

    public void withdraw(UUID playerId, double amount) {
        if (getBalance(playerId) >= amount) {
            playerBalances.put(playerId, getBalance(playerId) - amount);
        }
    }

    public void transfer(UUID fromPlayerId, UUID toPlayerId, double amount) {
        if (getBalance(fromPlayerId) >= amount) {
            withdraw(fromPlayerId, amount);
            deposit(toPlayerId, amount);
        }
    }

    public boolean deductBalance(UUID playerId, double amount) {
        if (getBalance(playerId) >= amount) {
            withdraw(playerId, amount);
            return true;
        }
        return false;
    }

    public void updateBalance(UUID playerId, double amount) {
        deposit(playerId, amount);
    }
}
