package net.raeen.aetheriusmod.combat;

public class StatusEffect {
    private final String name;
    private final String effectType;
    private final int duration; // in seconds

    public StatusEffect(String name, String effectType, int duration) {
        this.name = name;
        this.effectType = effectType;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getEffectType() {
        return effectType;
    }

    public int getDuration() {
        return duration;
    }
}
