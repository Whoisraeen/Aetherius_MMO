package net.raeen.aetheriusmod.quests;

import java.util.List;

public class DeliveryQuest extends Quest {
    private final String deliveryLocation;

    public DeliveryQuest(String name, String description, List<String> objectives, int experienceReward, List<String> itemRewards, int currencyReward, String deliveryLocation) {
        super(name, description, objectives, experienceReward, itemRewards, currencyReward);
        this.deliveryLocation = deliveryLocation;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }
}
