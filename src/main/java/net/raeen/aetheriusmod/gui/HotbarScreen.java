package net.raeen.aetheriusmod.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.raeen.aetheriusmod.hotbar.Hotbar;

public class HotbarScreen extends Screen {
    private static final ResourceLocation HOTBAR_TEXTURE = new ResourceLocation("aetheriusmod", "textures/gui/hotbar.png");
    private static final int HOTBAR_WIDTH = 182;
    private static final int HOTBAR_HEIGHT = 22;
    private final Hotbar hotbar;

    protected HotbarScreen(Hotbar hotbar) {
        super(Component.translatable("Hotbar"));
        this.hotbar = hotbar;
    }

    @Override
    protected void init() {
        // Add buttons for hotbar slots
        for (int i = 0; i < hotbar.getItems().size(); i++) {
            int x = (this.width / 2 - HOTBAR_WIDTH / 2) + i * 20;
            this.addRenderableWidget(new Button(x, this.height - 40, 20, 20, Component.translatable("Slot " + (i + 1)), button -> {
                // Handle hotbar slot click
            }));
        }
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        RenderSystem.setShaderTexture(0, HOTBAR_TEXTURE);
        int x = (this.width - HOTBAR_WIDTH) / 2;
        int y = this.height - 40;
        blit(x, y, 0, 0, HOTBAR_WIDTH, HOTBAR_HEIGHT);

        // Render hotbar items
        for (int i = 0; i < hotbar.getItems().size(); i++) {
            ItemStack itemStack = hotbar.getItems().get(i);
            // Render each item in the hotbar
        }

        super.render(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
