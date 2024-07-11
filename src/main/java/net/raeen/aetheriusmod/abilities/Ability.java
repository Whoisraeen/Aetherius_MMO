package net.raeen.aetheriusmod.abilities;

public class Ability {
    private final String name;
    private final String description;

    public Ability(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void activate() {
        // Logic for activating the ability
        System.out.println(name + " ability activated!");
    }
}
