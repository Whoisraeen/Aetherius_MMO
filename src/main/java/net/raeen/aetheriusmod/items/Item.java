package net.raeen.aetheriusmod.items;

public class Item {
    private final String name;
    private final String description;
    private final int rarity;
    private final String itemType;

    public Item(String name, String description, int rarity, String itemType) {
        this.name = name;
        this.description = description;
        this.rarity = rarity;
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRarity() {
        return rarity;
    }

    public String getItemType() {
        return itemType;
    }
}
