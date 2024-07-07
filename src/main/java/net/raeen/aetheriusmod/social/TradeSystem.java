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
        tradeOffers.put(playerName, item);
    }

    public void removeTradeOffer(String playerName) {
        tradeOffers.remove(playerName);
    }

    public Item getTradeOffer(String playerName) {
        return tradeOffers.get(playerName);
    }
}
