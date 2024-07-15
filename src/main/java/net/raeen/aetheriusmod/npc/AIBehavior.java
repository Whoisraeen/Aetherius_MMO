package net.raeen.aetheriusmod.npc;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

import java.util.Map;

public abstract class AIBehavior extends Behavior<ServerPlayer> {
    private final String name;

    public AIBehavior(String name, Map<MemoryModuleType<?>, MemoryStatus> requiredMemoryState) {
        super(requiredMemoryState);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void execute(ServerPlayer player);
}
