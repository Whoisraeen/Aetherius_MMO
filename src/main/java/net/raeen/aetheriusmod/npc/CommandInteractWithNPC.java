package net.raeen.aetheriusmod.npc;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.raeen.aetheriusmod.quests.QuestManager;

public class CommandInteractWithNPC {
    private static final NPCManager npcManager = new NPCManager();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
    dispatcher.register(Commands.literal("interactnpc")
            .then(Commands.argument("npcName", StringArgumentType.string())
                    .executes(context -> {
                        ServerPlayer player = context.getSource().getPlayerOrException();
                        String npcName = StringArgumentType.getString(context, "npcName");
                        NPC npc = npcManager.getNPCByName(npcName);

                        if (npc != null) {
                            NPCInteractionHandler interactionHandler = new NPCInteractionHandler();
                            interactionHandler.interactWithNPC(player, npc);
                            return 1; // Success
                        } else {
                            player.sendSystemMessage(Component.literal("NPC not found"));
                            return 0; // Failure
                        }
                    })));
}
}
