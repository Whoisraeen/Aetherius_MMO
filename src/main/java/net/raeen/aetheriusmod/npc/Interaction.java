package net.raeen.aetheriusmod.npc;

import net.minecraft.server.level.ServerPlayer;

public class Interaction {
    private final String description;
    private final Response response;

    public Interaction(String description, Response response) {
        this.description = description;
        this.response = response;
    }

    public String getDescription() {
        return description;
    }

    public Response getResponse() {
        return response;
    }

    public void execute(ServerPlayer player) {
        response.execute(player);
    }
}
