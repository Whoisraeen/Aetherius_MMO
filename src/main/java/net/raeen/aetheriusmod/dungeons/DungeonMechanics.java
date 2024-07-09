package net.raeen.aetheriusmod.dungeons;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.Random;

public class DungeonMechanics {
    private final Random random = new Random();

    public void spawnMobs(ServerLevel world, DungeonInstance instance) {
        for (int i = 0; i < 10; i++) {
            Mob zombie = new Zombie(world);
            zombie.setPos(instance.getDungeon().getEntrance().getX(), instance.getDungeon().getEntrance().getY(), instance.getDungeon().getEntrance().getZ());
            world.addFreshEntity(zombie);
        }
    }

    public void distributeLoot(DungeonInstance instance) {
        for (Player player : instance.getParticipants()) {
            ItemStack loot = new ItemStack(Items.DIAMOND, random.nextInt(3) + 1);
            player.getInventory().add(loot);
        }
    }

    public boolean checkCompletion(DungeonInstance instance) {
        // Logic to check if the dungeon is completed
        return true; // Example completion criteria
    }
}
