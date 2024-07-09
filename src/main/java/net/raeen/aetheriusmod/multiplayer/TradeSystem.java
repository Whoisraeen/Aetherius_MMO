package net.raeen.aetheriusmod.multiplayer;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TradeSystem {
    private final Map<UUID, Trade> activeTrades = new HashMap<>();

    public void initiateTrade(Player player1, Player player2) {
        Trade trade = new Trade(player1.getUUID(), player2.getUUID());
        activeTrades.put(player1.getUUID(), trade);
        activeTrades.put(player2.getUUID(), trade);
    }

    public void addItemToTrade(UUID playerId, ItemStack item) {
        Trade trade = activeTrades.get(playerId);
        if (trade != null) {
            trade.addItem(playerId, item);
        }
    }

    public void completeTrade(UUID playerId) {
        Trade trade = activeTrades.get(playerId);
        if (trade != null) {
            trade.complete();
            activeTrades.remove(trade.getPlayer1());
            activeTrades.remove(trade.getPlayer2());
        }
    }
}

class Trade {
    private final UUID player1;
    private final UUID player2;
    private final Map<UUID, ItemStack> player1Items = new HashMap<>();
    private final Map<UUID, ItemStack> player2Items = new HashMap<>();

    public Trade(UUID player1, UUID player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public UUID getPlayer1() {
        return player1;
    }

    public UUID getPlayer2() {
        return player2;
    }

    public void addItem(UUID playerId, ItemStack item) {
        if (playerId.equals(player1)) {
            player1Items.put(playerId, item);
        } else if (playerId.equals(player2)) {
            player2Items.put(playerId, item);
        }
    }

    public void complete() {
        // Logic to complete trade and transfer items
    }
}
