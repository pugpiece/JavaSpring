package app.services.interfaces;

import app.entities.Customer;

public interface ICustomerService {
    void addCustomer(Customer customer);
    Iterable<Customer> getAllCustomers();
    Customer getCustomer(int id);
    void updateCustomerName(int id, String newName);
    void deleteCustomer(int id);
}
