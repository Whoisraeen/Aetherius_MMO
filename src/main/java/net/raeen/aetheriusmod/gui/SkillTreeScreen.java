package net.raeen.aetheriusmod.gui;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.raeen.aetheriusmod.skills.Skill;
import net.raeen.aetheriusmod.skills.SkillTree;
import net.raeen.aetheriusmod.skills.SkillTreeManager;

import java.util.UUID;

public class SkillTreeScreen extends Screen {
    private final SkillTree skillTree;

    public SkillTreeScreen(UUID playerId, SkillTreeManager skillTreeManager) {
        super(Component.translatable("Skill Tree"));
        this.skillTree = skillTreeManager.getSkillTree(playerId);
    }

    @Override
    protected void init() {
        int y = 20;
        for (Skill skill : skillTree.getAllSkills().values()) {
            this.addRenderableWidget(Button.builder(Component.translatable(skill.getName() + ": " + skill.getCurrentLevel()), button -> {
                // Handle skill leveling up
            }).bounds(this.width / 2 - 100, y, 200, 20).build());
            y += 24;
        }

        this.addRenderableWidget(Button.builder(Component.translatable("Close"), button -> {
            this.minecraft.setScreen(null);
        }).bounds(this.width / 2 - 100, y, 200, 20).build());
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        drawCenteredString(this.font, this.title.getString(), this.width / 2, 10, 16777215);
        super.render(mouseX, mouseY, partialTicks);
    }
}
