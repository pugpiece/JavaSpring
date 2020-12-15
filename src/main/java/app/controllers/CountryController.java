package app.controllers;


import app.entities.Country;
import app.services.implementations.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    public final CountryService service;

    public CountryController(CountryService countryService) {
        this.service = countryService;
    }

    @GetMapping("/Countries")
    public Iterable<Country> getAllCountries(){
        return service.getAllCountries();
    }

    @GetMapping("/Country/{id}")
    public Country getCountry(@PathVariable int id){
        return  service.getCountry(id);
    }

    @GetMapping("/addCountry")
    public void addCountry(@RequestBody Country country){
        service.addCountry(country);
    }

    @GetMapping("/deleteCountry/{id}")
    public void deleteCountry(@PathVariable int id){
        service.deleteCountry(id);
    }

    @GetMapping("/updateCountryName/{id}")
    public void updateCountryName(@PathVariable int id, @RequestBody String name){
        service.updateCountryName(id, name);
    }
}
