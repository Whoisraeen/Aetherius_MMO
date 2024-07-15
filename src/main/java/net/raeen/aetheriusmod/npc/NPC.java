package net.raeen.aetheriusmod.npc;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.raeen.aetheriusmod.quests.Quest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NPC extends Entity {
    private static final EntityDataAccessor<Integer> DATA_ID = SynchedEntityData.defineId(NPC.class, EntityDataSerializers.INT);
    private final UUID id;
    private final String name;
    private final VillagerType villagerType;
    private final List<Quest> quests;
    private int posX, posY, posZ; // Assuming position is stored as coordinates

    public NPC(EntityType<?> entityType, Level level, String name, VillagerType villagerType) {
        super(entityType, level);
        this.id = UUID.randomUUID();
        this.name = name;
        this.villagerType = villagerType;
        this.quests = new ArrayList<>();
    }

    public NPC(EntityType<?> entityType, Level level) {
        this(entityType, level, "Default Name", VillagerType.PLAINS);
    }

    public NPC(String name, VillagerType villagerType, Level level) {
        super();
    }

    @Override
    protected void defineSynchedData() {
        // Define synchronized data
        this.entityData.define(DATA_ID, 0);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        // Read additional save data
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        // Add additional save data
    }

    @Override
    public Component getName() {
        return Component.literal(name);
    }

    public VillagerType getVillagerType() {
        return villagerType;
    }

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public UUID getUUID() {
        return id;
    }

    public void setPos(int x, int y, int z) {
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        setPos((double) x, (double) y, (double) z);
    }

    public boolean hasQuest() {
        return !quests.isEmpty();
    }

    public Quest getQuest() {
        return hasQuest() ? quests.get(0) : null; // Return the first quest if available
    }

    public void addQuest(Quest quest) {
        this.quests.add(quest);
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void interact(Player player) {
        // Logic for interaction
        player.sendSystemMessage(Component.literal("Interacting with " + name));
    }

    public String[] getDialogues() {
        // Return dialogues or add implementation here
        return new String[0];
    }
}
