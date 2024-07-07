package net.raeen.aetheriusmod.combat;

import net.raeen.aetheriusmod.character.GameCharacter;

public class CombatSystem {
    public static void attack(GameCharacter attacker, GameCharacter defender) {
        int damage = attacker.getAttribute("Strength") - defender.getAttribute("Durability");
        if (damage > 0) {
            defender.setAttribute("Health", defender.getAttribute("Health") - damage);
        }
    }

    public static void useSkill(GameCharacter user, String skill, GameCharacter target) {
        if (skill.equals("Fireball")) {
            int damage = user.getAttribute("Magic Proficiency") * 2;
            target.setAttribute("Health", target.getAttribute("Health") - damage);
            applyStatusEffect(target, new StatusEffect("Burning", "Damage Over Time", 5));
        }
        // Add more skills
    }

    public static void applyStatusEffect(GameCharacter target, StatusEffect effect) {
        // Handle the application of status effects
    }
}
