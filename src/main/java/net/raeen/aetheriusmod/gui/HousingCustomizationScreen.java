package net.raeen.aetheriusmod.gui;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.raeen.aetheriusmod.housing.Decoration;
import net.raeen.aetheriusmod.housing.Furniture;
import net.raeen.aetheriusmod.housing.FurnitureManager;
import net.raeen.aetheriusmod.housing.DecorationManager;

import java.util.ArrayList;
import java.util.List;

public class HousingCustomizationScreen extends Screen {
    private final FurnitureManager furnitureManager;
    private final DecorationManager decorationManager;
    private final List<Furniture> furnitureList;
    private final List<Decoration> decorationList;

    public HousingCustomizationScreen(FurnitureManager furnitureManager, DecorationManager decorationManager) {
        super(Component.translatable("Housing Customization"));
        this.furnitureManager = furnitureManager;
        this.decorationManager = decorationManager;
        this.furnitureList = new ArrayList<>();
        this.decorationList = new ArrayList<>();
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
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        drawCenteredString(guiGraphics, this.font, this.title.getString(), this.width / 2, 20, 16777215);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    private void drawCenteredString(GuiGraphics guiGraphics, Font font, String text, int x, int y, int color) {
        guiGraphics.drawCenteredString(font, text, x, y, color);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    public void addDecoration(Decoration decoration) {
        decorationList.add(decoration);
    }

    public void removeDecoration(Decoration decoration) {
        decorationList.remove(decoration);
    }

    public List<Decoration> getDecorationList() {
        return decorationList;
    }

    public void addFurniture(Furniture furniture) {
        furnitureList.add(furniture);
    }

    public void removeFurniture(Furniture furniture) {
        furnitureList.remove(furniture);
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void placeItem(Player player, ServerLevel level, BlockPos pos, ItemStack item) {
        // Logic to place item
    }

    public void removeItem(Player player, ServerLevel level, BlockPos pos) {
        // Logic to remove item
    }
}
