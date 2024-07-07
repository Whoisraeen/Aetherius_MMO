package net.raeen.aetheriusmod.cosmetics;

public class CosmeticItem {
    private final String name;
    private final String description;
    private final int price;

    public CosmeticItem(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
