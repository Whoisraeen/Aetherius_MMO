package net.raeen.aetheriusmod.quests;

import java.util.ArrayList;
import java.util.List;

public class BranchingQuest extends Quest {
    private final List<QuestObjective> objectives;
    private final List<BranchingQuest> nextBranches;

    public BranchingQuest(String name, String description, int reward) {
        super(name, description, reward);
        this.objectives = new ArrayList<>();
        this.nextBranches = new ArrayList<>();
    }

    public void addObjective(QuestObjective objective) {
        objectives.add(objective);
    }

    public List<QuestObjective> getObjectives() {
        return objectives;
    }

    public void addBranch(BranchingQuest quest) {
        nextBranches.add(quest);
    }

    public List<BranchingQuest> getNextBranches() {
        return nextBranches;
    }

    public boolean areAllObjectivesCompleted() {
        for (QuestObjective objective : objectives) {
            if (!objective.isCompleted()) {
                return false;
            }
        }
        return true;
    }
}
