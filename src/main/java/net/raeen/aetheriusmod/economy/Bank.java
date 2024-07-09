package net.raeen.aetheriusmod.economy;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Bank {
    private final Map<UUID, Double> accounts = new HashMap<>();

    public void createAccount(UUID playerId) {
        accounts.put(playerId, 0.0);
    }

    public double getBalance(UUID playerId) {
        return accounts.getOrDefault(playerId, 0.0);
    }

    public void deposit(UUID playerId, double amount) {
        accounts.put(playerId, getBalance(playerId) + amount);
    }

    public void withdraw(UUID playerId, double amount) {
        if (getBalance(playerId) >= amount) {
            accounts.put(playerId, getBalance(playerId) - amount);
        }
    }
}
