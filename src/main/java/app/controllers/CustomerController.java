package app.controllers;

import app.entities.Customer;
import app.entities.Dish;
import app.services.implementations.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    public final CustomerService service;

    public CustomerController(CustomerService customerService){
        this.service = customerService;
    }

    @GetMapping("/All")
    public Iterable<Customer> getAllCustomer(){
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id){
        return service.getCustomer(id);
    }

    @PostMapping("/Add")
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteCustomer(@PathVariable int id){
        service.deleteCustomer(id);
    }

    @PostMapping("/UpdateName/{id}")
    public void updateCustomerName(@PathVariable int id, @RequestBody String name){
        service.updateCustomerName(id, name);
    }


}
