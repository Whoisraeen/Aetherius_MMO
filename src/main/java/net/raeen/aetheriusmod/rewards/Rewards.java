package net.raeen.aetheriusmod.rewards;

import net.minecraft.server.level.ServerPlayer;

public class Rewards {
    public static void giveDailyQuestReward(ServerPlayer player, int reward) {
        player.giveExperiencePoints(reward);
        // Additional logic for giving rewards (items, currency, etc.)
    }

    public static void giveEventReward(ServerPlayer player, int reward) {
        player.giveExperiencePoints(reward);
        // Additional logic for giving rewards (items, currency, etc.)
    }

    public static void giveFactionQuestReward(ServerPlayer player, int reward) {
        player.giveExperiencePoints(reward);
        // Additional logic for giving rewards (items, currency, etc.)
    }
}
