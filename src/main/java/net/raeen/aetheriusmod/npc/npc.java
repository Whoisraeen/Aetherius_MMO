package net.raeen.aetheriusmod.npc;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.Level;
import net.raeen.aetheriusmod.quests.Quest;

import java.util.ArrayList;
import java.util.List;

public class NPC extends Villager {
    private String name;
    private List<Dialogue> dialogues;
    private List<Quest> quests;

    public NPC(String name, VillagerType villagerType, Level level) {
        super(villagerType, level);
        this.name = name;
        this.dialogues = new ArrayList<>();
        this.quests = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDialogue(Dialogue dialogue) {
        dialogues.add(dialogue);
    }

    public List<Dialogue> getDialogues() {
        return dialogues;
    }

    public void addQuest(Quest quest) {
        quests.add(quest);
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void interact(Player player) {
        // Logic for interacting with the player
    }
}
