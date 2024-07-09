package net.raeen.aetheriusmod.auction;

import net.raeen.aetheriusmod.economy.Economy;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuctionHouse {
    private final List<AuctionItem> auctionItems = new ArrayList<>();
    private final Economy economy;

    public AuctionHouse(Economy economy) {
        this.economy = economy;
    }

    public void listItem(AuctionItem item) {
        auctionItems.add(item);
    }

    public List<AuctionItem> getAuctionItems() {
        return auctionItems;
    }

    public AuctionItem getAuctionItem(UUID itemId) {
        return auctionItems.stream().filter(item -> item.getItemId().equals(itemId)).findFirst().orElse(null);
    }

    public boolean placeBid(UUID itemId, UUID bidderId, double bidAmount) {
        AuctionItem item = getAuctionItem(itemId);
        if (item != null && bidAmount > item.getCurrentBid() && economy.deductBalance(bidderId, bidAmount)) {
            if (item.getHighestBidder() != null) {
                economy.updateBalance(item.getHighestBidder(), item.getCurrentBid());
            }
            item.setCurrentBid(bidAmount, bidderId);
            return true;
        }
        return false;
    }

    public void completeAuction(UUID itemId) {
        AuctionItem item = getAuctionItem(itemId);
        if (item != null && item.getHighestBidder() != null) {
            economy.updateBalance(item.getSellerId(), item.getCurrentBid());
            auctionItems.remove(item);
        }
    }
}
