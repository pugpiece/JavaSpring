package app.controllers;

import app.entities.Instrument;
import app.entities.Product;
import app.entities.Shop;
import app.services.implementations.InstrumentService;
import app.services.implementations.ShopService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Shop")
public class ShopController {
    public final ShopService service;

    public ShopController(ShopService shopService){
        this.service = shopService;
    }

    @GetMapping("/All")
    public Iterable<Shop> getAllShops(){
        return service.getAllShops();
    }

    @GetMapping("/{id}")
    public Shop getShop(@PathVariable int id){
        return service.getShop(id);
    }

    @PostMapping("/Add")
    public void addShop(@RequestBody Shop shop){
        service.addShop(shop);
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteShop(@PathVariable int id){
        service.deleteShop(id);
    }

    @PostMapping("/UpdateName/{id}")
    public void updateShopName(@PathVariable int id, @RequestBody String name){
        service.updateShopName(id, name);
    }

    @PostMapping("/UpdateDescription/{id}")
    public void updateShopDescription(@PathVariable int id, @RequestBody String description){
        service.updateShopDescription(id, description);
    }

    @PostMapping("/AddProduct/{id}")
    public void addProduct(@PathVariable int id, @RequestBody Product product){
        service.addProduct(id, product);
    }

    @PostMapping("/AddInstrument/{id}")
    public void addInstrument(@PathVariable int id, @RequestBody Instrument instrument){
        service.addInstrument(id, instrument);
    }


}
