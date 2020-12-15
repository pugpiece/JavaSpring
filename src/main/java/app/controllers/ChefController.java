package app.controllers;

import app.entities.Chef;
import app.services.implementations.ChefService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChefController {
    public final ChefService service;

    public ChefController(ChefService chefService) {
        this.service = chefService;
    }

    @GetMapping("/Chefs")
    public Iterable<Chef> getAllChefs(){
        return service.getAllChefs();
    }

    @GetMapping("/Chef/{id}")
    public Chef getChef(@PathVariable int id){
        return  service.getChef(id);
    }

    @GetMapping("/addChef")
    public void addChef(@RequestBody Chef chef){
        service.addChef(chef);
    }

    @GetMapping("/deleteChef/{id}")
    public void deleteChef(@PathVariable int id){
        service.deleteChef(id);
    }

    @GetMapping("/updateChefName/{id}")
    public void updateChefName(@PathVariable int id, @RequestBody String name){
        service.updateChefName(id, name);
    }
}
