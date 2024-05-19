package emsi.orangers.nada_sr.services.Manager;

import emsi.orangers.nada_sr.dao.entities.Cart;
import emsi.orangers.nada_sr.dao.entities.CartItem;
import emsi.orangers.nada_sr.dao.entities.Product;

import java.util.List;

public interface CartManager {

    void addItemToCart(Long cartId, Long itemId, Integer quantity);

    void removeItemFromCart(Long cartItemId);

    Cart getCartById(Long cartId);

    boolean removeProductFromCart(Cart cart, Product product);

    void clearCart(Long cartId);

    List<CartItem> getCartItemsForCustomer(Long customerId);

    double getTotalPrice(Cart cart);
}