package emsi.orangers.nada_sr.services.Manager;

import emsi.orangers.nada_sr.dao.entities.Customer;
import jakarta.persistence.criteria.Order;

import java.util.List;

public interface OrderManager {

    Order createOrder(Order order);

    Order getOrderById(Long order);

    Order updateOrder(Order order);

    void deleteOrder(Long orderId);

    List<Order> getOrdersByCustomer(Customer customer);
}