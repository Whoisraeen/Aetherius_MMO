package net.raeen.aetheriusmod.housing;

public class PlayerHouse {
    private final String owner;
    private final String location;
    private final int size;

    public PlayerHouse(String owner, String location, int size) {
        this.owner = owner;
        this.location = location;
        this.size = size;
    }

    public String getOwner() {
        return owner;
    }

    public String getLocation() {
        return location;
    }

    public int getSize() {
        return size;
    }
}
