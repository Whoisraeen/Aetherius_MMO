package net.raeen.aetheriusmod.quests;

import java.util.ArrayList;
import java.util.List;

public class BranchingQuest extends Quest {
    private final List<QuestObjective> questObjectives;
    private final List<BranchingQuest> nextBranches;

    public BranchingQuest(String name, String description, List<String> objectives, int rewardExperience, List<String> rewards, int difficulty) {
        super(name, description, objectives, rewardExperience, rewards, difficulty);
        this.questObjectives = new ArrayList<>();
        this.nextBranches = new ArrayList<>();
    }

    public void addObjective(QuestObjective objective) {
        questObjectives.add(objective);
    }

    public List<QuestObjective> getQuestObjectives() {
        return questObjectives;
    }

    public void addBranch(BranchingQuest quest) {
        nextBranches.add(quest);
    }

    public List<BranchingQuest> getNextBranches() {
        return nextBranches;
    }

    public boolean areAllObjectivesCompleted() {
        for (QuestObjective objective : questObjectives) {
            if (!objective.isCompleted()) {
                return false;
            }
        }
        return true;
    }
}
