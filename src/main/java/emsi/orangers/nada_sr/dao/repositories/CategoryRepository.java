package emsi.orangers.nada_sr.dao.repositories;

import emsi.orangers.nada_sr.dao.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Vous pouvez ajouter des méthodes spécifiques au besoin
}

