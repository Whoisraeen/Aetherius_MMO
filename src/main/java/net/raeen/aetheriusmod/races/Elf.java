package net.raeen.aetheriusmod.races;

public class Elf extends Race {
    public Elf() {
        super("Elf", new String[]{"Agility", "Magic Proficiency"});
    }

    @Override
    public void applyRacialAbilities(net.raeen.aetheriusmod.character.GameCharacter character) {
        character.setAttribute("Agility", character.getAttribute("Agility") + 5);
        character.setAttribute("Magic Proficiency", character.getAttribute("Magic Proficiency") + 5);
    }
}
