package net.raeen.aetheriusmod.economy;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuctionHouseManager {
    private final Map<UUID, Auction> activeAuctions = new HashMap<>();
    private final Economy economy = new Economy();

    public void createAuction(ServerPlayer seller, ItemStack item, double startingBid) {
        Auction auction = new Auction(seller.getUUID(), item, startingBid);
        activeAuctions.put(seller.getUUID(), auction);
    }

    public void placeBid(ServerPlayer bidder, UUID auctionId, double bidAmount) {
        Auction auction = activeAuctions.get(auctionId);
        if (auction != null) {
            if (economy.getBalance(bidder.getUUID()) >= bidAmount) {
                auction.placeBid(bidder.getUUID(), bidAmount);
                economy.withdraw(bidder.getUUID(), bidAmount);
            }
        }
    }

    public void completeAuction(UUID auctionId) {
        Auction auction = activeAuctions.get(auctionId);
        if (auction != null) {
            UUID sellerId = auction.getSeller();
            UUID highestBidderId = auction.getHighestBidder();
            double highestBid = auction.getHighestBid();

            economy.deposit(sellerId, highestBid);
            // Transfer item from seller to highest bidder
            // Logic for item transfer
            activeAuctions.remove(auctionId);
        }
    }

    public Map<UUID, Auction> getActiveAuctions() {
        return activeAuctions;
    }
}
