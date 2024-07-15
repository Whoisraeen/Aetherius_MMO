package net.raeen.aetheriusmod.crafting;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
        // Checking if the held item is a specific item
        if (heldItem.getItem() == Items.DIAMOND_PICKAXE) { // Replace with the specific item you want to check
            // Adding a specific resource to the player's inventory
            player.getInventory().add(new ItemStack(Items.DIAMOND, 1)); // Replace with the specific resource item
        }
    }
}
