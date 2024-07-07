package net.raeen.aetheriusmod.mounts;

public class Mount {
    private final String name;
    private final int speed;

    public Mount(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
