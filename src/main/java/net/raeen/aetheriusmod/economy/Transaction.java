package net.raeen.aetheriusmod.economy;

import java.util.UUID;

public class Transaction {
    private final UUID fromPlayer;
    private final UUID toPlayer;
    private final double amount;

    public Transaction(UUID fromPlayer, UUID toPlayer, double amount) {
        this.fromPlayer = fromPlayer;
        this.toPlayer = toPlayer;
        this.amount = amount;
    }

    public UUID getFromPlayer() {
        return fromPlayer;
    }

    public UUID getToPlayer() {
        return toPlayer;
    }

    public double getAmount() {
        return amount;
    }
}
