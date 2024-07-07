package net.raeen.aetheriusmod.classes;

public class CharacterClass {
    private String name;
    private String[] skills;

    public CharacterClass(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String[] getSkills() {
        return skills;
    }
}
