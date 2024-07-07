package net.raeen.aetheriusmod.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class EquipmentScreen extends Screen {
    protected EquipmentScreen() {
        super(new TranslationTextComponent("Equipment Screen"));
    }

    @Override
    protected void init() {
        this.addButton(new Button(this.width / 2 - 100, this.height / 2 - 24, 200, 20, new StringTextComponent("Close"), button -> {
            this.minecraft.setScreen(null);
        }));
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        drawCenteredString(this.font, this.title.getString(), this.width / 2, 20, 16777215);
        super.render(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
