package net.raeen.aetheriusmod.items;

import java.util.HashMap;
import java.util.Map;

public class CraftingSystem {
    private final Map<String, String[]> recipes;

    public CraftingSystem() {
        this.recipes = new HashMap<>();
        initializeRecipes();
    }

    private void initializeRecipes() {
        recipes.put("Sword", new String[]{"Iron", "Wood"});
        recipes.put("Bow", new String[]{"String", "Wood"});
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
                // Craft the item
                return new Item(itemName, "Crafted " + itemName, 1);
            }
        }
        return null;
    }
}
