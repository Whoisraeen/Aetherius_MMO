package net.raeen.aetheriusmod.hotbar;

import net.minecraft.world.item.ItemStack;
import java.util.List;

public class Hotbar {
    private List<ItemStack> items;

    public Hotbar(List<ItemStack> items) {
        this.items = items;
    }

    public List<ItemStack> getItems() {
        return items;
    }

    public void setItems(List<ItemStack> items) {
        this.items = items;
    }

    public void updateItem(int slot, ItemStack item) {
        items.set(slot, item);
    }

    public void removeItem(int slot) {
        items.set(slot, ItemStack.EMPTY);
    }

    public void clearHotbar() {
        items.clear();
    }

    public void displayHotbar() {
        // Display hotbar items
    }
}
