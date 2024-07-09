package net.raeen.aetheriusmod.auction;

import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class AuctionItem {
    private final UUID itemId;
    private final ItemStack item;
    private final UUID sellerId;
    private double startingBid;
    private double currentBid;
    private UUID highestBidder;

    public AuctionItem(ItemStack item, UUID sellerId, double startingBid) {
        this.itemId = UUID.randomUUID();
        this.item = item;
        this.sellerId = sellerId;
        this.startingBid = startingBid;
        this.currentBid = startingBid;
        this.highestBidder = null;
    }

    public UUID getItemId() {
        return itemId;
    }

    public ItemStack getItem() {
        return item;
    }

    public UUID getSellerId() {
        return sellerId;
    }

    public double getStartingBid() {
        return startingBid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public UUID getHighestBidder() {
        return highestBidder;
    }

    public void setCurrentBid(double currentBid, UUID highestBidder) {
        this.currentBid = currentBid;
        this.highestBidder = highestBidder;
    }
}
