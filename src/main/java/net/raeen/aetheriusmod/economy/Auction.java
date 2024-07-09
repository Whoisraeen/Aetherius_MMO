package net.raeen.aetheriusmod.economy;

import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class Auction {
    private final UUID seller;
    private final ItemStack item;
    private final double startingBid;
    private UUID highestBidder;
    private double highestBid;

    public Auction(UUID seller, ItemStack item, double startingBid) {
        this.seller = seller;
        this.item = item;
        this.startingBid = startingBid;
        this.highestBid = startingBid;
    }

    public UUID getSeller() {
        return seller;
    }

    public ItemStack getItem() {
        return item;
    }

    public double getStartingBid() {
        return startingBid;
    }

    public UUID getHighestBidder() {
        return highestBidder;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public void placeBid(UUID bidder, double bidAmount) {
        if (bidAmount > highestBid) {
            highestBidder = bidder;
            highestBid = bidAmount;
        }
    }
}
