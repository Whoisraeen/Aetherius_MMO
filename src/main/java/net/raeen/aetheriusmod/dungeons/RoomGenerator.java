package net.raeen.aetheriusmod.dungeons;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

import java.util.Random;

public class RoomGenerator {
    private static final String[] ROOM_TYPES = {"Basic Room", "Treasure Room", "Trap Room", "Monster Room"};

    public static DungeonRoom generateRandomRoom(BlockPos position) {
        Random random = new Random();
        String roomType = ROOM_TYPES[random.nextInt(ROOM_TYPES.length)];
        return new DungeonRoom(roomType, position);
    }
}
