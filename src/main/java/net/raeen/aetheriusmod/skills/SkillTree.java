package net.raeen.aetheriusmod.skills;

import java.util.HashMap;
import java.util.Map;

public class SkillTree {
    private Map<String, Skill> skills;

    public SkillTree() {
        this.skills = new HashMap<>();
    }

    public void addSkill(Skill skill) {
        skills.put(skill.getName(), skill);
    }

    public Skill getSkill(String name) {
        return skills.get(name);
    }

    public Map<String, Skill> getAllSkills() {
        return skills;
    }
}
