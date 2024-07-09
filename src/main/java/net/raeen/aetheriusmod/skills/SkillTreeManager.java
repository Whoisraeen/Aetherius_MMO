package net.raeen.aetheriusmod.skills;

import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkillTreeManager {
    private final Map<UUID, SkillTree> playerSkillTrees = new HashMap<>();

    public SkillTree createSkillTree(UUID playerId) {
        SkillTree skillTree = new SkillTree();
        playerSkillTrees.put(playerId, skillTree);
        return skillTree;
    }

    public SkillTree getSkillTree(UUID playerId) {
        return playerSkillTrees.get(playerId);
    }

    public void addSkillToPlayer(UUID playerId, Skill skill) {
        SkillTree skillTree = getSkillTree(playerId);
        if (skillTree != null) {
            skillTree.addSkill(skill);
        }
    }

    public void levelUpSkill(UUID playerId, String skillName) {
        SkillTree skillTree = getSkillTree(playerId);
        if (skillTree != null) {
            Skill skill = skillTree.getSkill(skillName);
            if (skill != null && skill.getCurrentLevel() < skill.getMaxLevel()) {
                skill.levelUp();
            }
        }
    }
}
