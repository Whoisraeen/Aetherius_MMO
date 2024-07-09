package net.raeen.aetheriusmod.dungeons;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

import java.util.ArrayList;
import java.util.List;

public class DungeonFloor {
    private final List<DungeonRoom> rooms;
    private final BlockPos startPosition;

    public DungeonFloor(BlockPos startPosition) {
        this.rooms = new ArrayList<>();
        this.startPosition = startPosition;
    }

    public void addRoom(DungeonRoom room) {
        rooms.add(room);
    }

    public List<DungeonRoom> getRooms() {
        return rooms;
    }

    public void generate(ServerLevel world) {
        for (DungeonRoom room : rooms) {
            room.generate(world);
        }
    }
}
