package net.raeen.aetheriusmod.items;

public class RareItem extends Item {
    private final String specialAbility;

    public RareItem(String name, String description, int power, int durability, String specialAbility) {
        super(name, description, power, durability);
        this.specialAbility = specialAbility;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }
}
