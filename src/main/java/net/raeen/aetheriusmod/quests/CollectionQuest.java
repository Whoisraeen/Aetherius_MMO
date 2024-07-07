package net.raeen.aetheriusmod.quests;

import java.util.List;

public class CollectionQuest extends Quest {
    private final List<String> itemsToCollect;

    public CollectionQuest(String name, String description, List<String> objectives, int experienceReward, List<String> itemRewards, int currencyReward, List<String> itemsToCollect) {
        super(name, description, objectives, experienceReward, itemRewards, currencyReward);
        this.itemsToCollect = itemsToCollect;
    }

    public List<String> getItemsToCollect() {
        return itemsToCollect;
    }
}
