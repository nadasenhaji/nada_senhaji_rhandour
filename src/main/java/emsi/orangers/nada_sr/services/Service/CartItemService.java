package emsi.orangers.nada_sr.services.Service;

import emsi.orangers.nada_sr.dao.entities.Cart;
import emsi.orangers.nada_sr.dao.entities.CartItem;
import emsi.orangers.nada_sr.dao.entities.Product;
import emsi.orangers.nada_sr.dao.repositories.CartItemRepository;
import emsi.orangers.nada_sr.dao.repositories.CartRepository;
import emsi.orangers.nada_sr.dao.repositories.ProductRepository;
import emsi.orangers.nada_sr.services.Manager.CartItemManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService implements CartItemManager {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository, CartRepository cartRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void addCartItem(Long cartId, Long itemId, Integer quantity) {

        // Retrieve the cart by its ID
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found"));

        // Retrieve the menu item by its ID
        Product product = productRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Menu item not found"));

        // Create a new cart item
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        // Save the new cart item
        cartItemRepository.save(cartItem);
    }

    @Override
    public void removeCartItem(Long cartItemId) {

        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public CartItem getCartItemById(Long cartItemId) {
        return cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new EntityNotFoundException("Cart item not found"));
    }
}
