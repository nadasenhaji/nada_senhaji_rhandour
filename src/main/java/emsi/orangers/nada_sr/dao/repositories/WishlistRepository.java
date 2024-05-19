package emsi.orangers.nada_sr.dao.repositories;

import emsi.orangers.nada_sr.dao.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    Wishlist findByCustomerCustomerId(Long customerId);
}

