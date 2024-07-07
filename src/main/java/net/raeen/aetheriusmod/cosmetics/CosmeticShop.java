package net.raeen.aetheriusmod.cosmetics;

import java.util.List;

public class CosmeticShop {
    private List<CosmeticItem> items;

    public void updateItems(List<CosmeticItem> newItems) {
        this.items = newItems;
    }

    public List<CosmeticItem> getItems() {
        return items;
    }
}
