package net.raeen.aetheriusmod.dungeons;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

public class DungeonManager {
    private final List<DungeonInstance> activeDungeons = new ArrayList<>();

    public DungeonInstance createInstance(String name, ServerLevel world, List<Player> players) {
        BlockPos entryPoint = new BlockPos(200, 64, 200);
        DungeonFloor[] floors = new DungeonFloor[3];

        for (int i = 0; i < floors.length; i++) {
            DungeonFloor floor = new DungeonFloor(entryPoint.offset(0, -i * 10, 0));
            for (int j = 0; j < 5; j++) {
                floor.addRoom(RoomGenerator.generateRandomRoom(entryPoint.offset(j * 10, -i * 10, 0)));
            }
            floors[i] = floor;
        }

        DungeonInstance instance = new DungeonInstance(name, world, entryPoint, players, floors);
        activeDungeons.add(instance);
        return instance;
    }

    public List<DungeonInstance> getActiveDungeons() {
        return activeDungeons;
    }
}
