package net.raeen.aetheriusmod.quests;

import java.util.ArrayList;
import java.util.List;

public class QuestLog {
    private final List<Quest> activeQuests;
    private final List<Quest> completedQuests;

    public QuestLog() {
        this.activeQuests = new ArrayList<>();
        this.completedQuests = new ArrayList<>();
    }

    public void addQuest(Quest quest) {
        activeQuests.add(quest);
    }

    public void completeQuest(Quest quest) {
        if (activeQuests.contains(quest)) {
            activeQuests.remove(quest);
            completedQuests.add(quest);
            // Additional code to handle rewards
        }
    }

    public List<Quest> getActiveQuests() {
        return activeQuests;
    }

    public List<Quest> getCompletedQuests() {
        return completedQuests;
    }
}
