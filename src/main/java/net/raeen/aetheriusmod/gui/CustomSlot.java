package net.raeen.aetheriusmod.gui;

import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class CustomSlot extends AbstractWidget {
    private static final ResourceLocation SLOT_TEXTURE = new ResourceLocation("aetheriusmod", "textures/gui/custom_slot.png");

    public CustomSlot(int x, int y, int width, int height, Component title) {
        super(x, y, width, height, title);
    }

    @Override
    public void renderButton(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, SLOT_TEXTURE);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        blit(poseStack, this.x, this.y, 0, 0, this.width, this.height, this.width, this.height);
        RenderSystem.disableBlend();

        // Render item in slot if any
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        // Handle slot click
    }
}
