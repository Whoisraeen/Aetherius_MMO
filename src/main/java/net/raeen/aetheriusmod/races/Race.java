package net.raeen.aetheriusmod.races;

public class Race {
    private String name;
    private String[] abilities;

    public Race(String name, String[] abilities) {
        this.name = name;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public String[] getAbilities() {
        return abilities;
    }
}
