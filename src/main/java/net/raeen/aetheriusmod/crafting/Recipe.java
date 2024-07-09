package net.raeen.aetheriusmod.crafting;

import net.minecraft.world.item.Item;

import java.util.List;

public class Recipe {
    private List<Item> ingredients;
    private Item result;

    public Recipe(List<Item> ingredients, Item result) {
        this.ingredients = ingredients;
        this.result = result;
    }

    public List<Item> getIngredients() {
        return ingredients;
    }

    public Item getResult() {
        return result;
    }
}
