package app.controllers;

import app.entities.Dish;
import app.services.implementations.DishService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {
    public final DishService service;

    public DishController (DishService dishService) {
        this.service = dishService;
    }

    @GetMapping("/Dishes")
    public Iterable<Dish> getAllDishes(){
        return service.getAllDishes();
    }

    @GetMapping("/Dish/{id}")
    public Dish getDish(@PathVariable int id){
        return  service.getDish(id);
    }

    @GetMapping("/addDish")
    public void addDish(@RequestBody Dish dish){
        service.addDish(dish);
    }

    @GetMapping("/deleteDish/{id}")
    public void deleteDish(@PathVariable int id){
        service.deleteDish(id);
    }

    @GetMapping("/updateDishName/{id}")
    public void updateDishName(@PathVariable int id, @RequestBody String name){
        service.updateDishName(id, name);
    }

    @GetMapping("/updateDishRecipe/{id}")
    public void updateDishDesc(@PathVariable int id, @RequestBody String recipe){
        service.updateDishRecipe(id, recipe);
    }
}
