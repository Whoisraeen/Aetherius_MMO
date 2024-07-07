package net.raeen.aetheriusmod.pets;

public class Pet {
    private final String name;
    private final String ability;

    public Pet(String name, String ability) {
        this.name = name;
        this.ability = ability;
    }

    public String getName() {
        return name;
    }

    public String getAbility() {
        return ability;
    }
}
