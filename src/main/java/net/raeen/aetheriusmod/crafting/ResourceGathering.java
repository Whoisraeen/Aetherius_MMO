package net.raeen.aetheriusmod.crafting;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ResourceGathering {
    @SubscribeEvent
    public static void onPlayerBreakBlock(PlayerEvent.BreakSpeed event) {
        ServerPlayer player = (ServerPlayer) event.getEntity();
        ItemStack heldItem = player.getMainHandItem();

        // Example: Add a specific resource to player's inventory when they break a specific block
        if (heldItem.getItem().equals(/* specific tool */)) {
            player.getInventory().add(new ItemStack(/* specific resource */));
        }
    }
}
