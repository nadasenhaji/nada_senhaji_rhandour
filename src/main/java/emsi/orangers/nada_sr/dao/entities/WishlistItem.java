package emsi.orangers.nada_sr.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "WishlistItem")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishlistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishlistItemId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "wishlistId")
    private Wishlist wishlist;

}
