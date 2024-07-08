package net.raeen.aetheriusmod.quests;

import java.util.ArrayList;
import java.util.List;

public class QuestLog {
    private final List<Quest> quests;

    public QuestLog() {
        this.quests = new ArrayList<>();
    }

    public void addQuest(Quest quest) {
        this.quests.add(quest);
    }

    public void removeQuest(Quest quest) {
        this.quests.remove(quest);
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void completeQuest(Quest quest) {
        quest.advanceStage();
        if (quest.getCurrentStage() == quest.getObjectives().size() - 1) {
            removeQuest(quest);
        }
    }
}
