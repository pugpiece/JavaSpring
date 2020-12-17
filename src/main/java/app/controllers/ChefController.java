package app.controllers;

import app.entities.Chef;
import app.services.implementations.ChefService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Chef")
public class ChefController {
    public final ChefService service;

    public ChefController(ChefService chefService) {
        this.service = chefService;
    }

    @GetMapping(value = "/All")
    public Iterable<Chef> getAllChefs(){
        return service.getAllChefs();
    }

    @GetMapping(value = "/{id}")
    public Chef getChef(@PathVariable int id){
        return  service.getChef(id);
    }

    @PostMapping(value = "/Add")
    public void addChef(@RequestBody Chef chef){
        service.addChef(chef);
    }

    @DeleteMapping(value = "/Delete/{id}")
    public void deleteChef(@PathVariable int id){
        service.deleteChef(id);
    }

    @PostMapping(value = "/UpdateName/{id}")
    public void updateChefName(@PathVariable int id, @RequestBody String name){
        service.updateChefName(id, name);
    }
}
