package app.controllers;

import app.entities.Instrument;
import app.entities.Product;
import app.services.implementations.InstrumentService;
import app.services.implementations.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Product")
public class ProductController {
    public final ProductService service;

    public ProductController(ProductService productService){
        this.service = productService;
    }

    @GetMapping("/All")
    public Iterable<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id){
        return service.getProduct(id);
    }

    @PostMapping("/Add")
    public void addProduct(@RequestBody Product product){
        service.addProduct(product);
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
    }

    @PostMapping("/UpdateName/{id}")
    public void updateProductName(@PathVariable int id, @RequestBody String name){
        service.updateProductName(id, name);
    }

    @PostMapping("/UpdateDescription/{id}")
    public void updateProductDescription(@PathVariable int id, @RequestBody float cost){
        service.updateProductCost(id, cost);
    }

    @PostMapping("/updateProductFats/{id}")
    public void updateProductFats(@PathVariable int id, @RequestBody float fats){
        service.updateProductFats(id, fats);
    }

    @PostMapping("/updateProductCalories/{id}")
    public void updateProductCalories(@PathVariable int id, @RequestBody float calories){
        service.updateProductCalories(id, calories);
    }

    @PostMapping("/updateProductCarbohydrates/{id}")
    public void updateProductCarbohydrates(@PathVariable int id, @RequestBody float carbohydrates){
        service.updateProductCarbohydrates(id, carbohydrates);
    }

    @PostMapping("/updateProductProteins(/{id}")
    public void updateProductProteins(@PathVariable int id, @RequestBody float proteins){
        service.updateProductProteins(id, proteins);
    }


}
