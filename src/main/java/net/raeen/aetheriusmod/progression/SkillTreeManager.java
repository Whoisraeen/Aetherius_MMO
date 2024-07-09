package net.raeen.aetheriusmod.progression;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkillTreeManager {
    private final Map<UUID, SkillTree> playerSkillTrees;

    public SkillTreeManager() {
        this.playerSkillTrees = new HashMap<>();
    }

    public void createSkillTree(UUID playerId) {
        playerSkillTrees.put(playerId, new SkillTree());
    }

    public SkillTree getSkillTree(UUID playerId) {
        return playerSkillTrees.get(playerId);
    }

    public void addSkillToPlayer(UUID playerId, Skill skill) {
        SkillTree skillTree = playerSkillTrees.get(playerId);
        if (skillTree != null) {
            skillTree.addSkill(skill);
        }
    }

    public void upgradeSkillForPlayer(UUID playerId, String skillName) {
        SkillTree skillTree = playerSkillTrees.get(playerId);
        if (skillTree != null) {
            skillTree.upgradeSkill(skillName);
        }
    }
}
