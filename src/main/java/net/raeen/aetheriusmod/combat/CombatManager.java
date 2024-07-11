package net.raeen.aetheriusmod.combat;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CombatManager {
    private final Map<UUID, Integer> cooldowns = new HashMap<>();

    public void performSpecialAttack(ServerPlayer player, CombatSkill skill, LivingEntity target) {
    if (!isOnCooldown(player.getUUID(), skill)) {
        skill.use();
        target.hurt(CustomDamageSource.playerAttack(player.level(), player), skill.getDamage());
        setCooldown(player.getUUID(), skill);
    } else {
        player.sendSystemMessage(Component.literal("Skill is on cooldown"), false);
    }
}

    public void blockAttack(ServerPlayer player) {
    // Logic for blocking an attack
    player.sendSystemMessage(Component.literal("Blocking attack"), false);
}

    public void dodgeAttack(ServerPlayer player) {
    // Logic for dodging an attack
    player.sendSystemMessage(Component.literal("Dodging attack"), false);
}

    public void applyStatusEffect(LivingEntity target, StatusEffect effect) {
        effect.applyEffect();
        // Logic to apply the status effect to the target
    }

    private boolean isOnCooldown(UUID playerId, CombatSkill skill) {
        return cooldowns.containsKey(playerId) && cooldowns.get(playerId) > 0;
    }

    private void setCooldown(UUID playerId, CombatSkill skill) {
        cooldowns.put(playerId, skill.getCooldown());
        // Logic to handle cooldown timing
    }
}
