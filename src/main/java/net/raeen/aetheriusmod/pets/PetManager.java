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

    public void levelUpPet(UUID playerId) {
        Pet pet = pets.get(playerId);
        if (pet != null) {
            pet.levelUp();
        }
    }
}
