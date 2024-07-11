package net.raeen.aetheriusmod.pets;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PetManager {
    private final Map<UUID, Pet> pets = new HashMap<>();

    public Pet getPet(UUID playerId) {
        return pets.get(playerId);
    }

    public void addPet(UUID playerId, Pet pet) {
        pets.put(playerId, pet);
    }


public class Pet {
    private String name;
    private int level;
    private int maxLevel;

    public Pet(String name, int maxLevel) {
        this.name = name;
        this.level = 1;
        this.maxLevel = maxLevel;
    }

    public void levelUp() {
        if (level < maxLevel) {
            level++;
        }
    }

    // Other methods...
}
}
