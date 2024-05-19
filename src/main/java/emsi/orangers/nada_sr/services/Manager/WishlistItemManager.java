package emsi.orangers.nada_sr.services.Manager;

import emsi.orangers.nada_sr.dao.entities.WishlistItem;

public interface WishlistItemManager {
    void addItemToWishlist(Long wishlistId, Long itemId);

    void removeItemFromWishlist(Long wishlistItemId);

    WishlistItem getWishlistItemById(Long wishlistItemId);
}
