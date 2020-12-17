package app.services.implementations;

import app.entities.Customer;
import app.reposes.CustomerRepository;
import app.services.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateCustomerName(int id, String newName) {
        Customer customer = customerRepository.findById(id).get();
        customer.setCustomerLogin(newName);
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);

    }
}
