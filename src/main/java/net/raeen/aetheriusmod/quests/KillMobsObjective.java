package net.raeen.aetheriusmod.quests;

import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerPlayer;

public class KillMobsObjective extends QuestObjective {
    private final EntityType<?> mobType;
    private final int requiredKills;
    private int currentKills;

    public KillMobsObjective(String description, EntityType<?> mobType, int requiredKills) {
        super(description);
        this.mobType = mobType;
        this.requiredKills = requiredKills;
        this.currentKills = 0;
    }

    public void incrementKills() {
        currentKills++;
        if (currentKills >= requiredKills) {
            complete();
        }
    }

    public EntityType<?> getMobType() {
        return mobType;
    }

    public int getRequiredKills() {
        return requiredKills;
    }

    public int getCurrentKills() {
        return currentKills;
    }
}
