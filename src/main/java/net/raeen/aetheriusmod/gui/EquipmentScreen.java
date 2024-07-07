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

    private String getItemName(String armor) {
        // Add your logic to get the item name based on the armor type
        // For example:
        // return character.getEquipment().getItem(armor).getName();
        return "";
    }
}