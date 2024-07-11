package net.raeen.aetheriusmod.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;

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

    private void blit(PoseStack poseStack, int x, int y, int uOffset, int vOffset, int uWidth, int vHeight, int textureWidth, int textureHeight) {
        innerBlit(poseStack.last().pose(), x, x + uWidth, y, y + vHeight, getBlitOffset(), (uOffset / (float) textureWidth), ((uOffset + uWidth) / (float) textureWidth), (vOffset / (float) textureHeight), ((vOffset + vHeight) / (float) textureHeight));
    }

    private static void innerBlit(Matrix4f matrix, int x0, int x1, int y0, int y1, int z, float minU, float maxU, float minV, float maxV) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, SLOT_TEXTURE);
        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix, (float) x0, (float) y1, (float) z).uv(minU, maxV).endVertex();
        bufferbuilder.vertex(matrix, (float) x1, (float) y1, (float) z).uv(maxU, maxV).endVertex();
        bufferbuilder.vertex(matrix, (float) x1, (float) y0, (float) z).uv(maxU, minV).endVertex();
        bufferbuilder.vertex(matrix, (float) x0, (float) y0, (float) z).uv(minU, minV).endVertex();
        BufferUploader.drawWithShader(bufferbuilder.end());
    }
}
