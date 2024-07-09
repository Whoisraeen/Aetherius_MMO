package net.raeen.aetheriusmod.crafting;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import java.util.HashMap;
import java.util.Map;

public class GatheringManager {
    private final Map<String, GatheringNode> gatheringNodes = new HashMap<>();

    public void addGatheringNode(GatheringNode node) {
        gatheringNodes.put(node.getName(), node);
    }

    public GatheringNode getGatheringNode(String name) {
        return gatheringNodes.get(name);
    }

    public void gatherResource(ServerLevel world, String nodeName) {
        GatheringNode node = gatheringNodes.get(nodeName);
        if (node != null) {
            node.gather(world);
        }
    }
}
