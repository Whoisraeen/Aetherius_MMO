package net.raeen.aetheriusmod.housing;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.raeen.aetheriusmod.gui.HousingCustomizationScreen;

public class DecorationManager {
    private final HousingCustomizationScreen housingCustomization;

    public DecorationManager(HousingCustomizationScreen housingCustomization) {
        this.housingCustomization = housingCustomization;
    }

    public void placeDecoration(ServerPlayer player, BlockPos pos, ItemStack item) {
        Decoration decoration = new Decoration(item.getDisplayName().getString(), item, pos);
        housingCustomization.addDecoration(decoration);

        if (item.getItem() instanceof BlockItem) {
            BlockItem blockItem = (BlockItem) item.getItem();
            BlockState blockState = blockItem.getBlock().defaultBlockState();
            ServerLevel serverLevel = player.serverLevel(); // Get the player's current level
            serverLevel.setBlock(pos, blockState, 3); // Using 3 for block update flags
        } else {
            // Handle error or log that item is not a block
        }
    }

    public void removeDecoration(ServerPlayer player, BlockPos pos) {
        Decoration decoration = housingCustomization.getDecorationList().stream()
                .filter(d -> d.getPosition().equals(pos))
                .findFirst().orElse(null);
        if (decoration != null) {
            housingCustomization.removeDecoration(decoration);
            ServerLevel serverLevel = player.serverLevel(); // Get the player's current level
            serverLevel.setBlock(pos, Blocks.AIR.defaultBlockState(), 3); // Using 3 for block update flags
        }
    }
}
