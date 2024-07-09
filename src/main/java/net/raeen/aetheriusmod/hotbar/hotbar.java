package net.raeen.aetheriusmod.hotbar;

import net.minecraft.world.item.ItemStack;
import net.raeen.aetheriusmod.abilities.Ability;

import java.util.List;
import java.util.Map;

public class Hotbar {
    private List<ItemStack> items;
    private Map<Integer, Ability> abilities;

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

    public void addAbility(int slot, Ability ability) {
        abilities.put(slot, ability);
    }

    public Ability getAbility(int slot) {
        return abilities.get(slot);
    }

    public void displayHotbar() {
        // Display hotbar items and abilities
    }
}
