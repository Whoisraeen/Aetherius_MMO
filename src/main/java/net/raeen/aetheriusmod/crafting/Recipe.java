package net.raeen.aetheriusmod.crafting;

import net.minecraft.world.item.ItemStack;
import java.util.List;

public class Recipe {
    private final String name;
    private final List<ItemStack> ingredients;
    private final ItemStack result;

    public Recipe(String name, List<ItemStack> ingredients, ItemStack result) {
        this.name = name;
        this.ingredients = ingredients;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public List<ItemStack> getIngredients() {
        return ingredients;
    }

    public ItemStack getResult() {
        return result;
    }
}
