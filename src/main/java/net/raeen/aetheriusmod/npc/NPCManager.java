package net.raeen.aetheriusmod.npc;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.raeen.aetheriusmod.quests.Quest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NPCManager {
    private final Map<UUID, NPC> npcs = new HashMap<>();

    public NPC createNPC(String name, Level level, VillagerType villagerType, BlockPos position) {
        NPC npc = new NPC(name, villagerType, level);
        npc.setPos(position.getX(), position.getY(), position.getZ());
        npcs.put(npc.getUUID(), npc);
        if (level instanceof ServerLevel) {
            ((ServerLevel) level).addFreshEntity(npc);
        }
        return npc;
    }

    public NPC getNPC(UUID id) {
        return npcs.get(id);
    }

    public void interactWithNPC(Player player, UUID npcId) {
        NPC npc = getNPC(npcId);
        if (npc != null) {
            npc.interact(player);
        }
    }

    public void assignQuestToNPC(UUID npcId, Quest quest) {
        NPC npc = getNPC(npcId);
        if (npc != null) {
            npc.addQuest(quest);
        }
    }
}
