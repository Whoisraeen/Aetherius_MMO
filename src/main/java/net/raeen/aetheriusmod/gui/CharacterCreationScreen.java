package net.raeen.aetheriusmod.gui;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.raeen.aetheriusmod.classes.GameCharacter;
import net.raeen.aetheriusmod.classes.CharacterClass;
import net.raeen.aetheriusmod.races.Elf;
import net.raeen.aetheriusmod.races.Race;

import java.util.Arrays;

public class CharacterCreationScreen extends Screen {
    private String characterName = "";
    private Race selectedRace = new Elf(); // Default race selection

    protected CharacterCreationScreen() {
        super(Component.translatable("character_creation"));
    }

    @Override
    protected void init() {
        // Add widgets for character name input, race selection, etc.

        this.addRenderableWidget(Button.builder(Component.translatable("Create"), button -> {
            GameCharacter newCharacter = new GameCharacter(characterName, selectedRace, new CharacterClass("Warrior", Arrays.asList("Strength", "Endurance")), "Custom appearance");
            // Save newCharacter and switch to game screen
        }).bounds(this.width / 2 - 100, this.height / 2 + 24, 200, 20).build());
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        drawCenteredString(guiGraphics, this.font, this.title.getString(), this.width / 2, 40, 16777215);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    private void drawCenteredString(GuiGraphics guiGraphics, Font font, String string, int x, int y, int color) {
        guiGraphics.drawCenteredString(font, string, x, y, color);
    }
}
