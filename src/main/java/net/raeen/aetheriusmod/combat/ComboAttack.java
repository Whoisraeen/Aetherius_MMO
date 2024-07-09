package net.raeen.aetheriusmod.combat;

import java.util.List;

public class ComboAttack {
    private final String name;
    private final List<CombatSkill> skills;

    public ComboAttack(String name, List<CombatSkill> skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public List<CombatSkill> getSkills() {
        return skills;
    }

    public void execute() {
        for (CombatSkill skill : skills) {
            skill.use();
        }
    }
}
