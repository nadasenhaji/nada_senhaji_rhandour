package emsi.orangers.nada_sr.services.Service;

import emsi.orangers.nada_sr.dao.entities.Cart;
import emsi.orangers.nada_sr.dao.entities.CartItem;
import emsi.orangers.nada_sr.dao.entities.Product;
import emsi.orangers.nada_sr.dao.repositories.CartItemRepository;
import emsi.orangers.nada_sr.dao.repositories.CartRepository;
import emsi.orangers.nada_sr.dao.repositories.ProductRepository;
import emsi.orangers.nada_sr.services.Manager.CartManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements CartManager {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void addItemToCart(Long cartId, Long itemId, Integer quantity) {

        // Get the cart
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found"));

        // Get the menu item
        Product product = productRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Menu item not found"));

        // Create a new cart item
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        // Add the cart item to the cart
        cart.getCartItems().add(cartItem);

        // Save the updated cart
        cartRepository.save(cart);
    }

    @Override
    public void removeItemFromCart(Long cartItemId) {

        // Retrieve the cart item by its ID
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new EntityNotFoundException("Cart item not found"));

        // Retrieve the cart associated with the cart item
        Cart cart = cartItem.getCart();

        // Remove the cart item from the cart
        cart.getCartItems().remove(cartItem);

        // Save the updated cart
        cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(Long cartId) {
        return null;
    }

    @Override
    public boolean removeProductFromCart(Cart cart, Product product) {
        return false;
    }

    @Override
    public void clearCart(Long cartId) {

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found"));

        // Clear all items from the cart
        cart.getCartItems().clear();

        // Save the updated cart
        cartRepository.save(cart);
    }

    @Override
    public List<CartItem> getCartItemsForCustomer(Long customerId) {
        // Retrieve the cart for the given customer
        Cart cart = cartRepository.findByCustomerCustomerId(customerId);

        if (cart != null) {
            // If the cart exists, return its cart items
            return cart.getCartItems();
        } else {
            // If the cart does not exist (empty cart), return an empty list
            return List.of();
        }
    }

    @Override
    public double getTotalPrice(Cart cart) {
        return 0;
    }
}
