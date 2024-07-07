package net.raeen.aetheriusmod.progression;

public class Progression {
    private int level;
    private int experience;
    private int experienceToNextLevel;
    private final SkillTree skillTree;

    public Progression() {
        this.level = 1;
        this.experience = 0;
        this.experienceToNextLevel = 100; // Initial XP requirement
        this.skillTree = new SkillTree();
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
        unlockSkills();
    }

    private void unlockSkills() {
        String[] newSkills = skillTree.getSkillsForLevel(level);
        if (newSkills.length > 0) {
            System.out.println("New skills unlocked: " + String.join(", ", newSkills));
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
}
