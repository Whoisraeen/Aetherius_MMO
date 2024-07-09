package net.raeen.aetheriusmod.quests;

import net.minecraft.world.item.Item;

public class CollectItemsObjective extends QuestObjective {
    private final Item item;
    private final int requiredAmount;
    private int currentAmount;

    public CollectItemsObjective(String description, Item item, int requiredAmount) {
        super(description);
        this.item = item;
        this.requiredAmount = requiredAmount;
        this.currentAmount = 0;
    }

    public void addItem(int amount) {
        currentAmount += amount;
        if (currentAmount >= requiredAmount) {
            complete();
        }
    }

    public Item getItem() {
        return item;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }
}
