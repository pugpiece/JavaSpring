package app.controllers;

import app.entities.*;
import app.services.implementations.DishService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Dish")
public class DishController {
    public final DishService service;

    public DishController (DishService dishService) {
        this.service = dishService;
    }

    @GetMapping("/All")
    public Iterable<Dish> getAllDishes(){
        return service.getAllDishes();
    }

    @GetMapping("/All&Countries")
    public Iterable<Dish> getAllDishesCountries(){
        return service.getAllDishesCountries();
    }

    @GetMapping("/{id}")
    public Dish getDish(@PathVariable int id){
        return  service.getDish(id);
    }

    @PostMapping("/Add")
    public void addDish(@RequestBody Dish dish){
        service.addDish(dish);
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteDish(@PathVariable int id){
        service.deleteDish(id);
    }

    @PostMapping("/UpdateName/{id}")
    public void updateDishName(@PathVariable int id, @RequestBody String name){
        service.updateDishName(id, name);
    }

    @PostMapping("/UpdateRecipe/{id}")
    public void updateDishDesc(@PathVariable int id, @RequestBody String recipe){
        service.updateDishRecipe(id, recipe);
    }

    @PostMapping("/UpdateCountry/{id}")
    public void updateDishCountry(@PathVariable int id, @RequestBody Country country){
        service.updateCountry(id, country);
    }

    @PostMapping("/UpdateChef/{id}")
    public void updateDishChef(@PathVariable int id, @RequestBody Chef chef){
        service.updateChef(id, chef);
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
