package net.raeen.aetheriusmod.quests;

public class QuestObjective {
    private final String description;
    private boolean completed;

    public QuestObjective(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        this.completed = true;
    }
}
