package emsi.orangers.nada_sr.dao.repositories;

import emsi.orangers.nada_sr.dao.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Vous pouvez ajouter des méthodes spécifiques au besoin
}

