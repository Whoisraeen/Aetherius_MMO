package net.raeen.aetheriusmod.territory;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.raeen.aetheriusmod.guild.GuildManager;

@Mod.EventBusSubscriber
public class TerritoryEvents {
    private static final TerritoryManager territoryManager = new TerritoryManager(new GuildManager());

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent event) {
        // Logic to handle player interactions with territories
        // For example, initiating a war or capturing a territory
    }
}
