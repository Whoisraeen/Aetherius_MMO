package net.raeen.aetheriusmod.combat;

import net.raeen.aetheriusmod.character.GameCharacter;

public class CombatSystem {
    public static void attack(GameCharacter attacker, GameCharacter defender) {
        int damage = attacker.getAttribute("Strength") - defender.getAttribute("Durability");
        if (damage > 0) {
            // Apply damage to defender
        }
        // Additional combat mechanics
    }

    public static void useSkill(GameCharacter user, String skill, GameCharacter target) {
        // Implement skill effects
    }
}
