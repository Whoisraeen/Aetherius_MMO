package net.raeen.aetheriusmod.combat;

import net.raeen.aetheriusmod.character.GameCharacter;
import net.raeen.aetheriusmod.abilities.Ability;

public class CombatSystem {
    public void applyStatusEffect(GameCharacter character, StatusEffect effect) {
        // Apply the status effect
        System.out.println("Applying " + effect.getName() + " to " + character.getName());
    }

    public void useAbility(GameCharacter character, String abilityName) {
        Ability ability = character.getAbilities().get(abilityName);
        if (ability != null) {
            ability.activate();
            // Logic to apply ability effects
            System.out.println(character.getName() + " used " + ability.getName());
        } else {
            System.out.println("Ability " + abilityName + " not found for " + character.getName());
        }
    }
}
