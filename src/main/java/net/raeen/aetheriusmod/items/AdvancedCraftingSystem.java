package net.raeen.aetheriusmod.items;

import java.util.HashMap;
import java.util.Map;

public class AdvancedCraftingSystem {
    private final Map<String, String[]> recipes;

    public AdvancedCraftingSystem() {
        this.recipes = new HashMap<>();
        initializeRecipes();
    }

    private void initializeRecipes() {
        recipes.put("Advanced Sword", new String[]{"Diamond", "Wood"});
        recipes.put("Magic Wand", new String[]{"Crystal", "Wood"});
        // Add more recipes
    }

    public Item craftItem(String itemName, String[] materials) {
        if (recipes.containsKey(itemName)) {
            String[] requiredMaterials = recipes.get(itemName);
            boolean canCraft = true;
            for (String material : requiredMaterials) {
                boolean found = false;
                for (String providedMaterial : materials) {
                    if (providedMaterial.equals(material)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    canCraft = false;
                    break;
                }
            }
            if (canCraft) {
                return new Item(itemName, "Crafted " + itemName, 1, 0);
            }
        }
        return null;
    }
}

