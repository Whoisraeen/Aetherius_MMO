package net.raeen.aetheriusmod.gui;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class TitleScreen extends Screen {
    public TitleScreen() {
        super(Component.translatable("title_screen"));
    }

    @Override
    protected void init() {
        this.addRenderableWidget(Button.builder(Component.translatable("Play"), button -> {
            this.minecraft.setScreen(new CharacterSelectionScreen());
        }).bounds(this.width / 2 - 100, this.height / 2 - 24, 200, 20).build());

        this.addRenderableWidget(Button.builder(Component.translatable("Options"), button -> {
            // Open options screen
        }).bounds(this.width / 2 - 100, this.height / 2 + 24, 200, 20).build());

        this.addRenderableWidget(Button.builder(Component.translatable("Exit"), button -> {
            this.minecraft.shutdown();
        }).bounds(this.width / 2 - 100, this.height / 2 + 72, 200, 20).build());
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
