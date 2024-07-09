package net.raeen.aetheriusmod.housing;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HouseManager {
    private final Map<UUID, House> playerHouses = new HashMap<>();

    public House createHouse(UUID owner, BlockPos location) {
        House house = new House(owner, location);
        playerHouses.put(owner, house);
        return house;
    }

    public House getHouse(UUID owner) {
        return playerHouses.get(owner);
    }

    public void customizeHouse(UUID owner, BlockPos pos, BlockState state) {
        House house = getHouse(owner);
        if (house != null) {
            house.setBlock(pos, state);
        }
    }
}
