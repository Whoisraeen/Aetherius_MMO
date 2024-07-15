package net.raeen.aetheriusmod.housing;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.raeen.aetheriusmod.gui.HousingCustomizationScreen;

public class FurnitureManager {
    private final HousingCustomizationScreen housingCustomization;

    public FurnitureManager(HousingCustomizationScreen housingCustomization) {
        this.housingCustomization = housingCustomization;
    }

    public void placeFurniture(ServerPlayer player, BlockPos pos, ItemStack item) {
        Furniture furniture = new Furniture(item.getDisplayName().getString(), item, pos);
        housingCustomization.addFurniture(furniture);
        ServerLevel serverLevel = player.serverLevel(); // Get the player's current level
        housingCustomization.placeItem(player, serverLevel, pos, item);
    }

    public void removeFurniture(ServerPlayer player, BlockPos pos) {
        Furniture furniture = housingCustomization.getFurnitureList().stream()
                .filter(f -> f.getPosition().equals(pos))
                .findFirst().orElse(null);
        if (furniture != null) {
            housingCustomization.removeFurniture(furniture);
            ServerLevel serverLevel = player.serverLevel(); // Get the player's current level
            housingCustomization.removeItem(player, serverLevel, pos);
        }
    }
}

