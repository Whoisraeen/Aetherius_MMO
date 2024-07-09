package net.raeen.aetheriusmod.combat;

import java.util.ArrayList;
import java.util.List;

public class ComboAttackManager {
    private final List<ComboAttack> comboAttacks = new ArrayList<>();

    public void addComboAttack(ComboAttack combo) {
        comboAttacks.add(combo);
    }

    public List<ComboAttack> getComboAttacks() {
        return comboAttacks;
    }

    public void executeCombo(String comboName) {
        for (ComboAttack combo : comboAttacks) {
            if (combo.getName().equals(comboName)) {
                combo.execute();
                break;
            }
        }
    }
}
