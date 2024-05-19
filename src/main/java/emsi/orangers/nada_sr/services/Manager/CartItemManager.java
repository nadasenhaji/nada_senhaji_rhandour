package emsi.orangers.nada_sr.services.Manager;

import emsi.orangers.nada_sr.dao.entities.CartItem;

public interface CartItemManager {
    void addCartItem(Long cartId, Long itemId, Integer quantity);

    void removeCartItem(Long cartItemId);

    CartItem getCartItemById(Long cartItemId);
}
