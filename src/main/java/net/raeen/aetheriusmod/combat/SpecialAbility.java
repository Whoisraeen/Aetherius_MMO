package net.raeen.aetheriusmod.combat;

public class SpecialAbility {
    private final String name;
    private final String description;
    private final int cooldown;
    private boolean isAvailable;

    public SpecialAbility(String name, String description, int cooldown) {
        this.name = name;
        this.description = description;
        this.cooldown = cooldown;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCooldown() {
        return cooldown;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void activate() {
        if (isAvailable) {
            // Logic to activate the ability
            isAvailable = false;
            // Logic to handle cooldown
        }
    }

    public void resetCooldown() {
        isAvailable = true;
    }
}
