package net.raeen.aetheriusmod.housing;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.raeen.aetheriusmod.gui.HousingCustomizationScreen;

import java.util.UUID;

public class DecorationManager {
    private final HousingCustomizationScreen housingCustomization;

    public DecorationManager(HousingCustomizationScreen housingCustomization) {
        this.housingCustomization = housingCustomization;
    }

    public void placeDecoration(Player player, BlockPos pos, ItemStack item) {
        Decoration decoration = new Decoration(item.getDisplayName().getString(), item, pos);
        housingCustomization.addDecoration(decoration);
        housingCustomization.placeItem(player, player.getLevel(), pos, item);
    }

    public void removeDecoration(Player player, BlockPos pos) {
        Decoration decoration = housingCustomization.getDecorationList().stream()
                .filter(d -> d.getPosition().equals(pos))
                .findFirst().orElse(null);
        if (decoration != null) {
            housingCustomization.removeDecoration(decoration);
            housingCustomization.removeItem(player, player.getLevel(), pos);
        }
    }
}
