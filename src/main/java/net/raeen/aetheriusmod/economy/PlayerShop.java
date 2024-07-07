package net.raeen.aetheriusmod.economy;

import net.raeen.aetheriusmod.items.Item;

import java.util.HashMap;
import java.util.Map;

public class PlayerShop {
    private final String owner;
    private final Map<Item, Integer> itemsForSale;

    public PlayerShop(String owner) {
        this.owner = owner;
        this.itemsForSale = new HashMap<>();
    }

    public void addItemForSale(Item item, int price) {
        itemsForSale.put(item, price);
    }

    public Map<Item, Integer> getItemsForSale() {
        return itemsForSale;
    }
}
