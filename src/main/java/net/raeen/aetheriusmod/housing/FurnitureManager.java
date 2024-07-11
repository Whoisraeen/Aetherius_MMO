package net.raeen.aetheriusmod.housing;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.raeen.aetheriusmod.gui.HousingCustomizationScreen;

import java.util.UUID;

public class FurnitureManager {
    private final HousingCustomizationScreen housingCustomization;

    public FurnitureManager(HousingCustomizationScreen housingCustomization) {
        this.housingCustomization = housingCustomization;
    }

    public void placeFurniture(Player player, BlockPos pos, ItemStack item) {
        Furniture furniture = new Furniture(item.getDisplayName().getString(), item, pos);
        housingCustomization.addFurniture(furniture);
        housingCustomization.placeItem(player, player.getLevel(), pos, item);
    }

    public void removeFurniture(Player player, BlockPos pos) {
        Furniture furniture = housingCustomization.getFurnitureList().stream()
                .filter(f -> f.getPosition().equals(pos))
                .findFirst().orElse(null);
        if (furniture != null) {
            housingCustomization.removeFurniture(furniture);
            housingCustomization.removeItem(player, player.getLevel(), pos);
        }
    }
}
