package app.controllers;

import app.entities.Instrument;
import app.entities.Shop;
import app.services.implementations.InstrumentService;
import app.services.implementations.ShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
    public final ShopService service;

    public ShopController(ShopService shopService){
        this.service = shopService;
    }

    @GetMapping("/Shops")
    public Iterable<Shop> getAllShops(){
        return service.getAllShops();
    }

    @GetMapping("/Shop/{id}")
    public Shop getShop(@PathVariable int id){
        return service.getShop(id);
    }

    @GetMapping("/addShop")
    public void addShop(@RequestBody Shop shop){
        service.addShop(shop);
    }

    @GetMapping("/deleteShop/{id}")
    public void deleteShop(@PathVariable int id){
        service.deleteShop(id);
    }

    @GetMapping("/updateShopName/{id}")
    public void updateShopName(@PathVariable int id, @RequestBody String name){
        service.updateShopName(id, name);
    }

    @GetMapping("/updateShopDescription/{id}")
    public void updateShopDescription(@PathVariable int id, @RequestBody String description){
        service.updateShopDescription(id, description);
    }


}
