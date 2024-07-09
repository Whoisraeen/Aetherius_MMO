package net.raeen.aetheriusmod.npc;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BehaviorControl;

public abstract class AIBehavior extends Behavior<ServerPlayer> {
    private final String name;

    public AIBehavior(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void execute(ServerPlayer player);
}
