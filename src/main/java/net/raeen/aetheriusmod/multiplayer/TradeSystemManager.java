package net.raeen.aetheriusmod.multiplayer;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class TradeSystemManager {
    private final TradeSystem tradeSystem = new TradeSystem();

    public void initiateTrade(ServerPlayer player1, ServerPlayer player2) {
        tradeSystem.initiateTrade(player1, player2);
    }

    public void addItemToTrade(ServerPlayer player, ItemStack item) {
        tradeSystem.addItemToTrade(player.getUUID(), item);
    }

    public void completeTrade(ServerPlayer player) {
        tradeSystem.completeTrade(player.getUUID());
    }
}
