package net.raeen.aetheriusmod.social;

import net.raeen.aetheriusmod.items.Item;

import java.util.HashMap;
import java.util.Map;

public class Marketplace {
    private final Map<String, Item> listings;

    public Marketplace() {
        this.listings = new HashMap<>();
    }

    public void listItem(String playerName, Item item) {
        this.listings.put(playerName, item);
    }

    public Item getItem(String playerName) {
        return this.listings.get(playerName);
    }

    public void removeListing(String playerName) {
        this.listings.remove(playerName);
    }
}
