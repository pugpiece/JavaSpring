package app.controllers;

import app.entities.Customer;
import app.entities.Dish;
import app.services.implementations.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    public final CustomerService service;

    public CustomerController(CustomerService customerService){
        this.service = customerService;
    }

    @GetMapping("/Customers")
    public Iterable<Customer> getAllCustomer(){
        return service.getAllCustomers();
    }

    @GetMapping("/Customer/{id}")
    public Customer getCustomer(@PathVariable int id){
        return service.getCustomer(id);
    }

    @GetMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }

    @GetMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable int id){
        service.deleteCustomer(id);
    }

    @GetMapping("/updateCustomerName/{id}")
    public void updateCustomerName(@PathVariable int id, @RequestBody String name){
        service.updateCustomerName(id, name);
    }


}
