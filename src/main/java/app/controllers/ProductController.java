package app.controllers;

import app.entities.Instrument;
import app.entities.Product;
import app.services.implementations.InstrumentService;
import app.services.implementations.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    public final ProductService service;

    public ProductController(ProductService productService){
        this.service = productService;
    }

    @GetMapping("/Products")
    public Iterable<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/Product/{id}")
    public Product getProduct(@PathVariable int id){
        return service.getProduct(id);
    }

    @GetMapping("/addProduct")
    public void addProduct(@RequestBody Product product){
        service.addProduct(product);
    }

    @GetMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
    }

    @GetMapping("/updateProductName/{id}")
    public void updateProductName(@PathVariable int id, @RequestBody String name){
        service.updateProductName(id, name);
    }

    @GetMapping("/updateProductDescription/{id}")
    public void updateProductDescription(@PathVariable int id, @RequestBody float cost){
        service.updateProductCost(id, cost);
    }

    @GetMapping("/updateProductFats/{id}")
    public void updateProductFats(@PathVariable int id, @RequestBody float fats){
        service.updateProductFats(id, fats);
    }

    @GetMapping("/updateProductCalories/{id}")
    public void updateProductCalories(@PathVariable int id, @RequestBody float calories){
        service.updateProductCalories(id, calories);
    }

    @GetMapping("/updateProductCarbohydrates/{id}")
    public void updateProductCarbohydrates(@PathVariable int id, @RequestBody float carbohydrates){
        service.updateProductCarbohydrates(id, carbohydrates);
    }

    @GetMapping("/updateProductProteins(/{id}")
    public void updateProductProteins(@PathVariable int id, @RequestBody float proteins){
        service.updateProductProteins(id, proteins);
    }


}
