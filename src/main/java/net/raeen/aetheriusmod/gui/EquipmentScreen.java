package net.raeen.aetheriusmod.gui;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.raeen.aetheriusmod.character.GameCharacter;
import net.raeen.aetheriusmod.items.Item;

public class EquipmentScreen extends Screen {
    private final GameCharacter character;

    public EquipmentScreen(GameCharacter character) {
        super(new TranslationTextComponent("Equipment Screen"));
        this.character = character;
    }

    @Override
    protected void init() {
        this.addButton(new Button(this.width / 2 - 100, this.height / 2 - 24, 200, 20, new StringTextComponent("Close"), button -> {
            this.minecraft.setScreen(null);
        }));

        // Add buttons for each equipment slot
        this.addButton(new Button(this.width / 2 - 100, this.height / 2 - 64, 200, 20, new StringTextComponent("Helmet: " + getItemName("Helmet")), button -> {
            // Handle helmet slot
        }));
        this.addButton(new Button(this.width / 2 - 100, this.height / 2 - 104, 200, 20, new StringTextComponent("Armor: " + getItemName("Armor")), button -> {
            // Handle armor slot
        }));
        // Add more slots as needed
    }

    private void addButton(Button close) {
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

    private void drawCenteredString(Font font, String string, int i, int i1, int i2) {
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
