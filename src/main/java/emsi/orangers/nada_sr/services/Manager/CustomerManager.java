package emsi.orangers.nada_sr.services.Manager;

import emsi.orangers.nada_sr.dao.entities.Customer;

import java.util.List;

public interface CustomerManager {
    Customer createCustomer(Customer customer);

    Customer getCustomerById(Long customerId);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long customerId);

    List<Customer> getAllCustomers();
}
