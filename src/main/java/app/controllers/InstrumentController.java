package app.controllers;

import app.entities.Customer;
import app.entities.Instrument;
import app.services.implementations.CustomerService;
import app.services.implementations.InstrumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstrumentController {
    public final InstrumentService service;

    public InstrumentController(InstrumentService instrumentService){
        this.service = instrumentService;
    }

    @GetMapping("/Instruments")
    public Iterable<Instrument> getAllInstrument(){
        return service.getAllInstruments();
    }

    @GetMapping("/Instrument/{id}")
    public Instrument getInstrument(@PathVariable int id){
        return service.getInstrument(id);
    }

    @GetMapping("/addInstrument")
    public void addInstrument(@RequestBody Instrument instrument){
        service.addInstrument(instrument);
    }

    @GetMapping("/deleteInstrument/{id}")
    public void deleteInstrument(@PathVariable int id){
        service.deleteInstrument(id);
    }

    @GetMapping("/updateInstrumentName/{id}")
    public void updateInstrumentName(@PathVariable int id, @RequestBody String name){
        service.updateInstrumentName(id, name);
    }

    @GetMapping("/updateInstrumentDescription/{id}")
    public void updateInstrumentDescription(@PathVariable int id, @RequestBody String description){
        service.updateInstrumentDescription(id, description);
    }


}
