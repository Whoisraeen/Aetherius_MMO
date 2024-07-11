package net.raeen.aetheriusmod.races;

import net.raeen.aetheriusmod.classes.GameCharacter;

public class Dwarf extends Race {
    public Dwarf() {
        super("Dwarf", new String[]{"Strength", "Durability"});
    }

    @Override
    public void applyRacialAbilities(GameCharacter character) {
        character.setAttribute("Strength", character.getAttribute("Strength") + 5);
        character.setAttribute("Durability", character.getAttribute("Durability") + 5);
    }
}
