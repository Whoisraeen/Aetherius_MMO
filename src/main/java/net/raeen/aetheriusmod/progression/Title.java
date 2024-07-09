package net.raeen.aetheriusmod.progression;

public class Title {
    private final String name;
    private final String description;

    public Title(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
