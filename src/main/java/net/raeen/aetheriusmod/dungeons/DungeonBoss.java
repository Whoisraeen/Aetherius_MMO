package net.raeen.aetheriusmod.dungeons;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class DungeonBoss {
    private final EntityType<? extends Mob> bossType;
    private final BlockPos position;
    private final String specialAbility;

    public DungeonBoss(EntityType<? extends Mob> bossType, BlockPos position, String specialAbility) {
        this.bossType = bossType;
        this.position = position;
        this.specialAbility = specialAbility;
    }

    public void spawn(ServerLevel world) {
        Mob boss = bossType.create(world);
        if (boss != null) {
            boss.setPos(position.getX(), position.getY(), position.getZ());
            world.addFreshEntity(boss);
            // Logic for boss special abilities
        }
    }

    public String getSpecialAbility() {
        return specialAbility;
    }
}
