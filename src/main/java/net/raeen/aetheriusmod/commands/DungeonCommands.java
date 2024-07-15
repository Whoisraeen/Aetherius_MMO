package net.raeen.aetheriusmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.raeen.aetheriusmod.dungeons.Dungeon;
import net.raeen.aetheriusmod.dungeons.DungeonInstance;
import net.raeen.aetheriusmod.dungeons.DungeonManager;

import java.util.List;
import java.util.function.Supplier;

public class DungeonCommands {
    private static final DungeonManager dungeonManager = new DungeonManager();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("dungeon")
                .then(Commands.literal("register")
                        .then(Commands.argument("name", StringArgumentType.string())
                                .then(Commands.argument("layout", StringArgumentType.string())
                                        .then(Commands.argument("x", StringArgumentType.integer())
                                                .then(Commands.argument("y", StringArgumentType.integer())
                                                        .then(Commands.argument("z", StringArgumentType.integer())
                                                                .executes(context -> {
                                                                    String name = StringArgumentType.getString(context, "name");
                                                                    String layout = StringArgumentType.getString(context, "layout");
                                                                    int x = IntegerArgumentType.getInteger(context, "x");
                                                                    int y = IntegerArgumentType.getInteger(context, "y");
                                                                    int z = IntegerArgumentType.getInteger(context, "z");
                                                                    BlockPos entrance = new BlockPos(x, y, z);

                                                                    Dungeon dungeon = new Dungeon(name, layout, entrance);
                                                                    dungeonManager.registerDungeon(dungeon);

                                                                    context.getSource().sendSuccess(() -> Component.literal("Dungeon registered!"), true);
                                                                    return 1;
                                                                })))))))
                .then(Commands.literal("createInstance")
                        .then(Commands.argument("name", StringArgumentType.string())
                                .executes(context -> {
                                    String name = StringArgumentType.getString(context, "name");
                                    ServerPlayer player = context.getSource().getPlayerOrException();
                                    ServerLevel world = (ServerLevel) player.level;

                                    DungeonInstance instance = dungeonManager.createInstance(name, world, List.of(player));
                                    if (instance != null) {
                                        context.getSource().sendSuccess(() -> Component.literal("Dungeon instance created!"), true);
                                        return 1;
                                    } else {
                                        context.getSource().sendFailure(Component.literal("Failed to create dungeon instance."));
                                        return 0;
                                    }
                                }))));
    }
}
