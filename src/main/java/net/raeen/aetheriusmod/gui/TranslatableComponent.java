package net.raeen.aetheriusmod.gui;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;

public class TranslatableComponent implements Component {
    public TranslatableComponent(String equipmentScreen) {
    }

    @Override
    public Style getStyle() {
        return null;
    }

    @Override
    public ComponentContents getContents() {
        return null;
    }

    @Override
    public List<Component> getSiblings() {
        return List.of();
    }

    @Override
    public FormattedCharSequence getVisualOrderText() {
        return null;
    }
}
