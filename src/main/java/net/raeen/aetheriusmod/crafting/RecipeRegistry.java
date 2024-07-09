package net.raeen.aetheriusmod.crafting;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RecipeRegistry {
    public static void registerRecipes(CraftingManager manager) {
        List<ItemStack> ironSwordIngredients = new ArrayList<>();
        ironSwordIngredients.add(new ItemStack(Items.IRON_INGOT, 2));
        ironSwordIngredients.add(new ItemStack(Items.STICK, 1));
        Recipe ironSwordRecipe = new Recipe("Iron Sword", ironSwordIngredients, new ItemStack(Items.IRON_SWORD));
        manager.addRecipe(ironSwordRecipe);

        // Add more recipes as needed
    }
}
