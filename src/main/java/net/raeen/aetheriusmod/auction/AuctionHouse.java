package net.raeen.aetheriusmod.auction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuctionHouse {
    private final List<AuctionItem> auctionItems = new ArrayList<>();

    public void listItem(AuctionItem item) {
        auctionItems.add(item);
    }

    public List<AuctionItem> getAuctionItems() {
        return auctionItems;
    }

    public void bidOnItem(UUID bidder, int bidAmount, AuctionItem item) {
        if (bidAmount > item.getHighestBid()) {
            item.setHighestBid(bidAmount, bidder);
        }
    }

    public void finalizeAuction(AuctionItem item) {
        // Transfer item to highest bidder and funds to seller
    }
}
