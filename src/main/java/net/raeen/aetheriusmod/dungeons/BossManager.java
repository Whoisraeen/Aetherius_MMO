package net.raeen.aetheriusmod.dungeons;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class BossManager {
    public static DungeonBoss createBoss(EntityType<? extends Mob> bossType, BlockPos position, String specialAbility) {
        return new DungeonBoss(bossType, position, specialAbility);
    }

    public static void spawnBoss(DungeonBoss boss, ServerLevel world) {
        boss.spawn(world);
    }
}
