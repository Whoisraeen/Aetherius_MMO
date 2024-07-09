package net.raeen.aetheriusmod.npc;

public class CommandInteractWithNPC {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("interactnpc")
                .then(Commands.argument("npcName", StringArgumentType.string())
                        .executes(context -> {
                            ServerPlayer player = context.getSource().getPlayerOrException();
                            String npcName = StringArgumentType.getString(context, "npcName");
                            NPC npc = npcManager.getNPC(npcName);

                            if (npc != null) {
                                NPCInteractionHandler interactionHandler = new NPCInteractionHandler();
                                interactionHandler.interactWithNPC(player, npc);
                                return 1; // Success
                            } else {
                                player.sendMessage(new TextComponent("NPC not found"), player.getUUID());
                                return 0; // Failure
                            }
                        })));
    }
}

