package net.raeen.aetheriusmod.quests;

import java.util.ArrayList;
import java.util.List;

public class QuestLog {
    private final List<Quest> quests;

    public QuestLog() {
        this.quests = new ArrayList<>();
    }

    public void addQuest(Quest quest) {
        quests.add(quest);
    }

    public void completeQuest(Quest quest) {
        if (quests.contains(quest)) {
            quests.remove(quest);
            // Additional code to handle rewards
        }
    }

    public List<Quest> getQuests() {
        return quests;
    }
}
