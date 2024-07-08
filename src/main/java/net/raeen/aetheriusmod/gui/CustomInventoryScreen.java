package net.raeen.aetheriusmod.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;

public class CustomInventoryScreen extends Screen {
    private static final ResourceLocation INVENTORY_TEXTURE = new ResourceLocation("aetheriusmod", "textures/gui/custom_inventory.png");
    private static final int INVENTORY_WIDTH = 176;
    private static final int INVENTORY_HEIGHT = 166;

    protected CustomInventoryScreen() {
        super(Component.translatable("custom_inventory"));
    }

    @Override
    protected void init() {
        // Add custom buttons
        this.addRenderableWidget(new Button(this.width / 2 - 40, this.height / 2 - 22, 80, 20, Component.translatable("Button1"), button -> {
            // Button1 action
        }));
        this.addRenderableWidget(new Button(this.width / 2 - 40, this.height / 2 + 2, 80, 20, Component.translatable("Button2"), button -> {
            // Button2 action
        }));

        // Add custom slots and other components
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        RenderSystem.setShaderTexture(0, INVENTORY_TEXTURE);
        int x = (this.width - INVENTORY_WIDTH) / 2;
        int y = (this.height - INVENTORY_HEIGHT) / 2;
        blit(x, y, 0, 0, INVENTORY_WIDTH, INVENTORY_HEIGHT);

        // Render custom slots and other components

        super.render(mouseX, mouseY, partialTicks);
    }

    private void blit(int x, int y, int i, int i1, int inventoryWidth, int inventoryHeight) {
        
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
