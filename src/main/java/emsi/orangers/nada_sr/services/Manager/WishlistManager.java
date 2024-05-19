package emsi.orangers.nada_sr.services.Manager;

import emsi.orangers.nada_sr.dao.entities.Wishlist;
import emsi.orangers.nada_sr.dao.entities.WishlistItem;

import java.util.List;

public interface WishlistManager {
    void addItemToWishlist(Long wishlistId, Long itemId);

    void removeItemFromWishlist(Long wishlistItemId);

    Wishlist getWishlistById(Long wishlistId);

    void clearWishlist(Long wishlistId);

    // Method to get all wishlist items for a given customer
    List<WishlistItem> getWishlistItemsForCustomer(Long customerId);
}
