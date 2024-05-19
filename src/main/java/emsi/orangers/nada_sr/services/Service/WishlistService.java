package emsi.orangers.nada_sr.services.Service;

import emsi.orangers.nada_sr.dao.entities.Product;
import emsi.orangers.nada_sr.dao.entities.Wishlist;
import emsi.orangers.nada_sr.dao.entities.WishlistItem;
import emsi.orangers.nada_sr.dao.repositories.ProductRepository;
import emsi.orangers.nada_sr.dao.repositories.WishlistItemRepository;
import emsi.orangers.nada_sr.dao.repositories.WishlistRepository;
import emsi.orangers.nada_sr.services.Manager.WishlistManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService implements WishlistManager {

    private final WishlistRepository wishlistRepository;
    private final WishlistItemRepository wishlistItemRepository;
    private final ProductRepository productRepository;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository, WishlistItemRepository wishlistItemRepository, ProductRepository productRepository) {
        this.wishlistRepository = wishlistRepository;
        this.wishlistItemRepository = wishlistItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<WishlistItem> getWishlistItemsForCustomer(Long customerId) {
        // Retrieve the wishlist for the given customer
        Wishlist wishlist = wishlistRepository.findByCustomerCustomerId(customerId);

        if (wishlist != null) {
            // If the wishlist exists, return its wishlist items
            return wishlist.getWishlistItems();
        } else {
            // If the wishlist does not exist (empty wishlist), return an empty list
            return List.of();
        }
    }

    @Override
    public void addItemToWishlist(Long wishlistId, Long itemId) {

        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new EntityNotFoundException("Wishlist not found"));

        Product product = productRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Menu item not found"));

        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setWishlist(wishlist);
        wishlistItem.setProduct(product);

        wishlistItemRepository.save(wishlistItem);
    }

    @Override
    public void removeItemFromWishlist(Long wishlistItemId) {

        WishlistItem wishlistItem = wishlistItemRepository.findById(wishlistItemId)
                .orElseThrow(() -> new EntityNotFoundException("Wishlist item not found"));

        wishlistItemRepository.delete(wishlistItem);
    }

    @Override
    public Wishlist getWishlistById(Long wishlistId) {

        return wishlistRepository.findById(wishlistId)
                .orElse(null);
    }

    @Override
    public void clearWishlist(Long wishlistId) {

        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new EntityNotFoundException("Wishlist not found"));

        List<WishlistItem> wishlistItems = wishlist.getWishlistItems();
        wishlistItems.clear();
        wishlistRepository.save(wishlist);
    }
}

