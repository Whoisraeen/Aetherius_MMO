package net.raeen.aetheriusmod.combat;

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
            target.hurt(DamageSource.playerAttack(player), skill.getDamage());
            setCooldown(player.getUUID(), skill);
        } else {
            player.sendMessage(Component.literal("Skill is on cooldown"), Util.NIL_UUID);
        }
    }

    public void blockAttack(ServerPlayer player) {
        // Logic for blocking an attack
        player.sendMessage(Component.literal("Blocking attack"), Util.NIL_UUID);
    }

    public void dodgeAttack(ServerPlayer player) {
        // Logic for dodging an attack
        player.sendMessage(Component.literal("Dodging attack"), Util.NIL_UUID);
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
