package emsi.orangers.nada_sr.dao.repositories;

import emsi.orangers.nada_sr.dao.entities.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {
    // Vous pouvez ajouter des méthodes spécifiques au besoin
}

