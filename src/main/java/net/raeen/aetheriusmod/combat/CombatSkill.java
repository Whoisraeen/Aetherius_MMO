package net.raeen.aetheriusmod.combat;

public class CombatSkill {
    private String name;
    private String description;
    private int damage;
    private int cooldown;

    public CombatSkill(String name, String description, int damage, int cooldown) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.cooldown = cooldown;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDamage() {
        return damage;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void use() {
        // Logic to use the combat skill
        System.out.println("Using combat skill: " + name);
    }
}
