package net.raeen.aetheriusmod.titles;

public class Title {
    private final String name;
    private final String requirement;

    public Title(String name, String requirement) {
        this.name = name;
        this.requirement = requirement;
    }

    public String getName() {
        return name;
    }

    public String getRequirement() {
        return requirement;
    }
}
