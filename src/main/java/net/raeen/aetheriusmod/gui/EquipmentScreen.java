package net.raeen.aetheriusmod.gui;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.raeen.aetheriusmod.character.GameCharacter;
import net.raeen.aetheriusmod.items.Item;

public class EquipmentScreen extends Screen {
    private final GameCharacter character;

    public EquipmentScreen(GameCharacter character) {
        super(Component.translatable("equipment_screen"));
        this.character = character;
    }

    @Override
    protected void init() {
        this.addRenderableWidget(Button.builder(Component.translatable("Close"), button -> {
            this.minecraft.setScreen(null);
        }).bounds(this.width / 2 - 100, this.height / 2 - 24, 200, 20).build());

        // Add buttons for each equipment slot
        this.addRenderableWidget(Button.builder(Component.translatable("Helmet: " + getItemName("Helmet")), button -> {
            // Handle helmet slot
        }).bounds(this.width / 2 - 100, this.height / 2 - 64, 200, 20).build());

        this.addRenderableWidget(Button.builder(Component.translatable("Armor: " + getItemName("Armor")), button -> {
            // Handle armor slot
        }).bounds(this.width / 2 - 100, this.height / 2 - 104, 200, 20).build());

        // Add more slots as needed
    }

    private String getItemName(String slot) {
        Item item = character.getEquippedItem(slot);
        return item != null ? item.getName() : "None";
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
