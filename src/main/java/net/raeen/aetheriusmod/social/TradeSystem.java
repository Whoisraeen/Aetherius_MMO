package net.raeen.aetheriusmod.social;

import net.raeen.aetheriusmod.items.Item;

import java.util.HashMap;
import java.util.Map;

public class TradeSystem {
    private final Map<String, Item> tradeOffers;

    public TradeSystem() {
        this.tradeOffers = new HashMap<>();
    }

    public void addTradeOffer(String playerName, Item item) {
        this.tradeOffers.put(playerName, item);
    }

    public Item getTradeOffer(String playerName) {
        return this.tradeOffers.get(playerName);
    }
}
