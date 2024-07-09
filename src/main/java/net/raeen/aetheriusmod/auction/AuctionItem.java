package net.raeen.aetheriusmod.auction;

import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class AuctionItem {
    private UUID seller;
    private ItemStack item;
    private int startingBid;
    private int highestBid;
    private UUID highestBidder;

    public AuctionItem(UUID seller, ItemStack item, int startingBid) {
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

    public int getStartingBid() {
        return startingBid;
    }

    public int getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(int highestBid, UUID bidder) {
        this.highestBid = highestBid;
        this.highestBidder = bidder;
    }

    public UUID getHighestBidder() {
        return highestBidder;
    }
}
