package net.raeen.aetheriusmod.progression;

import java.util.HashMap;
import java.util.Map;

public class SkillTree {
    private final Map<Integer, String[]> skillsPerLevel;

    public SkillTree() {
        this.skillsPerLevel = new HashMap<>();
        initializeSkills();
    }

    private void initializeSkills() {
        skillsPerLevel.put(5, new String[]{"Skill A"});
        skillsPerLevel.put(10, new String[]{"Skill B"});
        skillsPerLevel.put(15, new String[]{"Skill C"});
        // Add more levels and skills as needed
    }

    public String[] getSkillsForLevel(int level) {
        return skillsPerLevel.getOrDefault(level, new String[]{});
    }
}
