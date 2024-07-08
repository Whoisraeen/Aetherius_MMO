package net.raeen.aetheriusmod.items;

public class Item {
    private final String name;
    private final String description;
    private final int power;
    private int durability;

    public Item(String name, String description, int power, int durability) {
        this.name = name;
        this.description = description;
        this.power = power;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPower() {
        return power;
    }

    public int getDurability() {
        return durability;
    }

    public void decreaseDurability(int amount) {
        this.durability -= amount;
        if (this.durability < 0) {
            this.durability = 0;
        }
    }

    public void repair(int amount) {
        this.durability += amount;
    }
}
