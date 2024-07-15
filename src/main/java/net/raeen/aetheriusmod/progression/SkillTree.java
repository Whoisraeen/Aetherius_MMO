package net.raeen.aetheriusmod.progression;

import java.util.HashMap;
import java.util.Map;

public class SkillTree {
    private final Map<String, Skill> skills;

    public SkillTree() {
        this.skills = new HashMap<>();
    }

    public void addSkill(Skill skill) {
        skills.put(skill.getName(), skill);
    }

    public Skill getSkill(String name) {
        return skills.get(name);
    }

    public Map<String, Skill> getSkills() {
        return skills;
    }

    public void upgradeSkill(String name) {
        Skill skill = skills.get(name);
        if (skill != null) {
            skill.upgrade();
        }
    }

    public String[] getSkillsForLevel(int level) {
        return null;
    }
}
