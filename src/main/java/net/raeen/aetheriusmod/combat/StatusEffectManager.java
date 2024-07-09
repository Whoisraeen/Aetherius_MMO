package net.raeen.aetheriusmod.combat;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StatusEffectManager {
    private final Map<UUID, StatusEffect> activeStatusEffects = new HashMap<>();

    public void applyStatusEffect(LivingEntity target, StatusEffect effect) {
        activeStatusEffects.put(target.getUUID(), effect);
        effect.applyEffect();
    }

    public void removeStatusEffect(LivingEntity target) {
        activeStatusEffects.remove(target.getUUID());
    }

    public StatusEffect getStatusEffect(LivingEntity target) {
        return activeStatusEffects.get(target.getUUID());
    }
}
