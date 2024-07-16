package net.raeen.aetheriusmod.npc;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.raeen.aetheriusmod.quests.Quest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class NPC extends Entity {
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
        this.entityData.define(DATA_ID, 0); // Ensure synched data is defined during construction
    }

    public NPC(EntityType<?> entityType, Level level) {
        this(entityType, level, "Default Name", VillagerType.PLAINS);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DATA_ID, 0);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        this.posX = tag.getInt("PosX");
        this.posY = tag.getInt("PosY");
        this.posZ = tag.getInt("PosZ");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putInt("PosX", this.posX);
        tag.putInt("PosY", this.posY);
        tag.putInt("PosZ", this.posZ);
    }

    @Override
    public Component getName() {
        return Component.literal(name);
    }

    public VillagerType getVillagerType() {
        return villagerType;
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
        player.sendSystemMessage(Component.literal("Interacting with " + name));
    }

    public String[] getDialogues() {
        return new String[0];
    }
}
