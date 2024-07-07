package net.raeen.aetheriusmod.progression;

import java.util.HashMap;
import java.util.Map;

public class Progression {
    private int level;
    private int experience;
    private int experienceToNextLevel;
    private Map<Integer, String[]> skillsPerLevel;

    public Progression() {
        this.level = 1;
        this.experience = 0;
        this.experienceToNextLevel = 100; // Initial XP requirement
        this.skillsPerLevel = new HashMap<>();
        initializeSkills();
    }

    private void initializeSkills() {
        // Example skills unlocked at specific levels
        skillsPerLevel.put(5, new String[]{"Skill A"});
        skillsPerLevel.put(10, new String[]{"Skill B"});
        skillsPerLevel.put(15, new String[]{"Skill C"});
        // Add more levels and skills as needed
    }

    public void gainExperience(int amount) {
        experience += amount;
        while (experience >= experienceToNextLevel) {
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        experience -= experienceToNextLevel;
        experienceToNextLevel *= 1.5; // Example progression formula
        System.out.println("Level Up! New Level: " + level);
        unlockSkills();
    }

    private void unlockSkills() {
        if (skillsPerLevel.containsKey(level)) {
            System.out.println("New skills unlocked: " + String.join(", ", skillsPerLevel.get(level)));
        }
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getExperienceToNextLevel() {
        return experienceToNextLevel;
    }

    public Map<Integer, String[]> getSkillsPerLevel() {
        return skillsPerLevel;
    }
}
