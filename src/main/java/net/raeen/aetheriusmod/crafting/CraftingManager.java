package net.raeen.aetheriusmod.crafting;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class CraftingManager {
    public ItemStack craft(ServerPlayer player, Recipe recipe) {
        List<Item> ingredients = recipe.getIngredients();
        for (Item ingredient : ingredients) {
            if (!player.getInventory().contains(new ItemStack(ingredient))) {
                // Player lacks an ingredient
                return ItemStack.EMPTY;
            }
        }

        for (Item ingredient : ingredients) {
            player.getInventory().removeItem(new ItemStack(ingredient));
        }

        return new ItemStack(recipe.getResult());
    }
}
