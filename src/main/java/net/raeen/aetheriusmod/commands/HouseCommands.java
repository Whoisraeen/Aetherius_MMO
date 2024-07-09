package net.raeen.aetheriusmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BlockPosArgument;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.state.BlockState;
import net.raeen.aetheriusmod.housing.HouseManager;

public class HouseCommands {
    private static final HouseManager houseManager = new HouseManager();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("house")
                .then(Commands.literal("create")
                        .then(Commands.argument("location", BlockPosArgument.blockPos())
                                .executes(context -> {
                                    BlockPos location = BlockPosArgument.getLoadedBlockPos(context, "location");
                                    ServerPlayer player = context.getSource().getPlayerOrException();

                                    houseManager.createHouse(player.getUUID(), location);

                                    context.getSource().sendSuccess(Component.literal("House created!"), true);
                                    return 1;
                                })))
                .then(Commands.literal("customize")
                        .then(Commands.argument("location", BlockPosArgument.blockPos())
                                .then(Commands.argument("block", StringArgumentType.string())
                                        .executes(context -> {
                                            BlockPos location = BlockPosArgument.getLoadedBlockPos(context, "location");
                                            String blockName = StringArgumentType.getString(context, "block");
                                            ServerPlayer player = context.getSource().getPlayerOrException();

                                            BlockState blockState = BlockStateArgument.getBlockState(context, "block");
                                            houseManager.customizeHouse(player.getUUID(), location, blockState);

                                            context.getSource().sendSuccess(Component.literal("House customized!"), true);
                                            return 1;
                                        })))));
    }
}
