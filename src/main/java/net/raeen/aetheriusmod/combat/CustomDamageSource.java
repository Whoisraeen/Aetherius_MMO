package net.raeen.aetheriusmod.combat;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class CustomDamageSource extends DamageSource {
    private final Entity attacker;

    public CustomDamageSource(Level level, Entity attacker) {
        super(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK));
        this.attacker = attacker;
    }

    public static DamageSource playerAttack(Level level, Entity attacker) {
        return new CustomDamageSource(level, attacker);
    }

    @Override
    public Entity getEntity() {
        return this.attacker;
    }
}
