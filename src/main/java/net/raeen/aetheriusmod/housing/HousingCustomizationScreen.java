package net.raeen.aetheriusmod.gui;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.raeen.aetheriusmod.housing.Decoration;
import net.raeen.aetheriusmod.housing.Furniture;
import net.raeen.aetheriusmod.housing.FurnitureManager;
import net.raeen.aetheriusmod.housing.DecorationManager;

public class HousingCustomizationScreen extends Screen {
    private final FurnitureManager furnitureManager;
    private final DecorationManager decorationManager;

    public HousingCustomizationScreen(FurnitureManager furnitureManager, DecorationManager decorationManager) {
        super(Component.translatable("Housing Customization"));
        this.furnitureManager = furnitureManager;
        this.decorationManager = decorationManager;
    }

    @Override
    protected void init() {
        this.addRenderableWidget(new Button.Builder(Component.translatable("Place Furniture"), button -> {
            // Logic to place furniture
        }).bounds(this.width / 2 - 100, this.height / 2 - 24, 200, 20).build());

        this.addRenderableWidget(new Button.Builder(Component.translatable("Remove Furniture"), button -> {
            // Logic to remove furniture
        }).bounds(this.width / 2 - 100, this.height / 2 + 24, 200, 20).build());

        this.addRenderableWidget(new Button.Builder(Component.translatable("Place Decoration"), button -> {
            // Logic to place decoration
        }).bounds(this.width / 2 - 100, this.height / 2 + 72, 200, 20).build());

        this.addRenderableWidget(new Button.Builder(Component.translatable("Remove Decoration"), button -> {
            // Logic to remove decoration
        }).bounds(this.width / 2 - 100, this.height / 2 + 120, 200, 20).build());
    }

    @Override
public void renderBackground() {
    this.renderBackgroundTexture(0);
}

private void renderBackgroundTexture(int i) {
    // Implement the logic to render the background texture
}

    private void renderBackgroundTexture(int i) {
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        drawCenteredString(this.font, this.title.getString(), this.width / 2, 20, 16777215);
        super.render(mouseX, mouseY, partialTicks);
    }

    private void drawCenteredString(Font font, Component text, int x, int y, int color) {
        drawCenteredString(font, text.getString(), x, y, color);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    public void addDecoration(Decoration decoration) {
    }

    public void addFurniture(Furniture furniture) {

    }
}
