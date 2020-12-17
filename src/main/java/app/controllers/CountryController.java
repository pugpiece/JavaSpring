package app.controllers;


import app.entities.Country;
import app.services.implementations.CountryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Country")
public class CountryController {
    public final CountryService service;

    public CountryController(CountryService countryService) {
        this.service = countryService;
    }

    @GetMapping("/All")
    public Iterable<Country> getAllCountries(){
        return service.getAllCountries();
    }

    @GetMapping("/{id}")
    public Country getCountry(@PathVariable int id){
        return  service.getCountry(id);
    }

    @PostMapping("/Add")
    public void addCountry(@RequestBody Country country){
        service.addCountry(country);
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteCountry(@PathVariable int id){
        service.deleteCountry(id);
    }

    @PostMapping("/UpdateName/{id}")
    public void updateCountryName(@PathVariable int id, @RequestBody String name){
        service.updateCountryName(id, name);
    }
}
