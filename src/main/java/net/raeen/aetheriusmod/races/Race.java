package net.raeen.aetheriusmod.races;

import net.raeen.aetheriusmod.character.GameCharacter;

import java.util.Arrays;
import java.util.List;

public abstract class Race {
    private final String name;
    private final List<String> traits;

    public Race(String name, String[] traits) {
        this.name = name;
        this.traits = Arrays.asList(traits);
    }

    public String getName() {
        return name;
    }

    public List<String> getTraits() {
        return traits;
    }

    public abstract void applyRacialAbilities(GameCharacter character);
}
