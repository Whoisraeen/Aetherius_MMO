package net.raeen.aetheriusmod.mobs;

public class Mob {
    private final String name;
    private final int health;
    private final int attackDamage;
    private final String biome;

    public Mob(String name, int health, int attackDamage, String biome) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.biome = biome;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public String getBiome() {
        return biome;
    }
}
