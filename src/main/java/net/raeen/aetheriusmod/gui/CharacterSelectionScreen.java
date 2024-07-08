package net.raeen.aetheriusmod.gui;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.raeen.aetheriusmod.character.GameCharacter;
import net.raeen.aetheriusmod.races.Elf;
import net.raeen.aetheriusmod.races.Dwarf;

public class CharacterSelectionScreen extends Screen {
    private GameCharacter selectedCharacter;

    protected CharacterSelectionScreen() {
        super(Component.translatable("character_selection"));
    }

    @Override
    protected void init() {
        this.addRenderableWidget(Button.builder(Component.translatable("Create New Character"), button -> {
            this.minecraft.setScreen(new CharacterCreationScreen());
        }).bounds(this.width / 2 - 100, this.height / 2 - 24, 200, 20).build());

        // Add buttons to select existing characters if any
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        drawCenteredString(this.font, this.title.getString(), this.width / 2, 40, 16777215);
        super.render(mouseX, mouseY, partialTicks);
    }

    private void drawCenteredString(Font font, String string, int i, int i1, int i2) {
    }
}
