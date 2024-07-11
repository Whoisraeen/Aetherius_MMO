package net.raeen.aetheriusmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.raeen.aetheriusmod.auction.AuctionHouse;
import net.raeen.aetheriusmod.auction.AuctionItem;
import net.raeen.aetheriusmod.economy.Economy;

import java.util.UUID;

public class AuctionHouseCommands {
    private static final Economy economy = new Economy();
    private static final AuctionHouse auctionHouse = new AuctionHouse(economy);

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("auction")
                .then(Commands.literal("list")
                        .then(Commands.argument("item", StringArgumentType.string())
                                .then(Commands.argument("startingBid", DoubleArgumentType.doubleArg())
                                        .executes(context -> {
                                            String itemName = StringArgumentType.getString(context, "item");
                                            double startingBid = DoubleArgumentType.getDouble(context, "startingBid");
                                            ServerPlayer player = context.getSource().getPlayerOrException();

                                            // Assuming getItemStackByName is a method to retrieve an ItemStack by its name
                                            ItemStack item = getItemStackByName(itemName);
                                            if (item != null) {
                                                AuctionItem auctionItem = new AuctionItem(item, player.getUUID(), startingBid);
                                                auctionHouse.listItem(auctionItem);
                                                context.getSource().sendSuccess(Component.literal("Item listed for auction!"), true);
                                                return 1;
                                            } else {
                                                context.getSource().sendFailure(Component.literal("Item not found."));
                                                return 0;
                                            }
                                        }))))
                .then(Commands.literal("bid")
                        .then(Commands.argument("itemId", StringArgumentType.string())
                                .then(Commands.argument("bidAmount", DoubleArgumentType.doubleArg())
                                        .executes(context -> {
                                            UUID itemId = UUID.fromString(StringArgumentType.getString(context, "itemId"));
                                            double bidAmount = DoubleArgumentType.getDouble(context, "bidAmount");
                                            ServerPlayer player = context.getSource().getPlayerOrException();

                                            if (auctionHouse.placeBid(itemId, player.getUUID(), bidAmount)) {
                                                context.getSource().sendSuccess(Component.literal("Bid placed successfully!"), true);
                                                return 1;
                                            } else {
                                                context.getSource().sendFailure(Component.literal("Failed to place bid."));
                                                return 0;
                                            }
                                        }))))
                .then(Commands.literal("complete")
                        .then(Commands.argument("itemId", StringArgumentType.string())
                                .executes(context -> {
                                    UUID itemId = UUID.fromString(StringArgumentType.getString(context, "itemId"));
                                    auctionHouse.completeAuction(itemId);
                                    context.getSource().sendSuccess(Component.literal("Auction completed!"), true);
                                    return 1;
                                }))));
    }

    private static ItemStack getItemStackByName(String name) {
        // Example method to retrieve an ItemStack by its name
        switch (name.toLowerCase()) {
            case "diamond":
                return new ItemStack(Items.DIAMOND);
            case "gold_ingot":
                return new ItemStack(Items.GOLD_INGOT);
            // Add more items as needed
            default:
                return null;
        }
    }
}
