package net.raeen.aetheriusmod.economy;

import java.util.UUID;

public class EconomyManager {
    private final Economy economy = new Economy();

    public void createAccount(UUID playerId) {
        economy.createAccount(playerId);
    }

    public double getBalance(UUID playerId) {
        return economy.getBalance(playerId);
    }

    public void deposit(UUID playerId, double amount) {
        economy.deposit(playerId, amount);
    }

    public void withdraw(UUID playerId, double amount) {
        economy.withdraw(playerId, amount);
    }

    public void transfer(UUID fromPlayerId, UUID toPlayerId, double amount) {
        economy.transfer(fromPlayerId, toPlayerId, amount);
    }
}
