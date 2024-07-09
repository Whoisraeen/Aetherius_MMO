package net.raeen.aetheriusmod.combat;

import java.util.ArrayList;
import java.util.List;

public class SpecialAbilityManager {
    private final List<SpecialAbility> abilities = new ArrayList<>();

    public void addAbility(SpecialAbility ability) {
        abilities.add(ability);
    }

    public List<SpecialAbility> getAbilities() {
        return abilities;
    }

    public void activateAbility(String abilityName) {
        for (SpecialAbility ability : abilities) {
            if (ability.getName().equals(abilityName) && ability.isAvailable()) {
                ability.activate();
                break;
            }
        }
    }

    public void resetCooldowns() {
        for (SpecialAbility ability : abilities) {
            ability.resetCooldown();
        }
    }
}
