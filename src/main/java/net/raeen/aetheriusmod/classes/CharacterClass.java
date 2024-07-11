package net.raeen.aetheriusmod.classes;

import java.util.List;

public class CharacterClass {
    private final String name;
    private final List<String> skills;

    public CharacterClass(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void displayClassInfo() {
        // Print class details
        System.out.println("Class: " + name);
        System.out.println("Skills: " + skills);
    }
}
