package net.raeen.aetheriusmod.crafting;

import net.minecraft.world.item.Item;

public class Resource {
    private String name;
    private Item item;

    public Resource(String name, Item item) {
        this.name = name;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public Item getItem() {
        return item;
    }
}
