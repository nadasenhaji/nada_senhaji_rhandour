package emsi.orangers.nada_sr.services.Service;

import emsi.orangers.nada_sr.dao.entities.Product;
import emsi.orangers.nada_sr.dao.entities.Wishlist;
import emsi.orangers.nada_sr.dao.entities.WishlistItem;
import emsi.orangers.nada_sr.dao.repositories.WishlistItemRepository;
import emsi.orangers.nada_sr.services.Manager.WishlistItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistItemService implements WishlistItemManager {

    private final WishlistItemRepository wishlistItemRepository;

    @Autowired
    public WishlistItemService(WishlistItemRepository wishlistItemRepository) {
        this.wishlistItemRepository = wishlistItemRepository;
    }

    @Override
    public void addItemToWishlist(Long wishlistId, Long itemId) {

        WishlistItem wishlistItem = new WishlistItem();

        // Create instances of Wishlist and MenuItem
        Wishlist wishlist = new Wishlist();
        wishlist.setWishlistId(wishlistId); // Set wishlistId if needed

        Product product = new Product();
        product.setProductId(itemId);
         // Set itemId if needed

        // Set associations
        wishlistItem.setWishlist(wishlist);
        wishlistItem.setProduct(product);

        // Save the wishlist item
        wishlistItemRepository.save(wishlistItem);
    }

    private void Id(Long itemId) {
    }


    @Override
    public void removeItemFromWishlist(Long wishlistItemId) {
        // Implement logic to remove an item from the wishlist
        wishlistItemRepository.deleteById(wishlistItemId);
    }

    @Override
    public WishlistItem getWishlistItemById(Long wishlistItemId) {
        // Implement logic to retrieve a wishlist item by ID
        return wishlistItemRepository.findById(wishlistItemId).orElse(null);
    }
}
