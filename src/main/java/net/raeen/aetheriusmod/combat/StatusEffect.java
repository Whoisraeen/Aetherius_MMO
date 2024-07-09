package net.raeen.aetheriusmod.combat;

public class StatusEffect {
    private String name;
    private String description;
    private int duration;
    private int effectStrength;

    public StatusEffect(String name, String description, int duration, int effectStrength) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.effectStrength = effectStrength;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public int getEffectStrength() {
        return effectStrength;
    }

    public void applyEffect() {
        // Logic to apply the status effect
        System.out.println("Applying status effect: " + name);
    }
}
