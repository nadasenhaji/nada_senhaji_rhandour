package emsi.orangers.nada_sr.dao.repositories;

import emsi.orangers.nada_sr.dao.entities.Customer;
import emsi.orangers.nada_sr.dao.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}

