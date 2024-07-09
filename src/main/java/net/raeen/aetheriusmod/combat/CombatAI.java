package net.raeen.aetheriusmod.combat;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

public class CombatAI extends Goal {
    private final Mob mob;

    public CombatAI(Mob mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        // Logic to determine if the AI can perform an action
        return true;
    }

    @Override
    public void start() {
        // Logic to start the AI action
    }

    @Override
    public void stop() {
        // Logic to stop the AI action
    }

    @Override
    public void tick() {
        // Logic for the AI to perform during each tick
    }
}
