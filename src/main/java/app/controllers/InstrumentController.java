package app.controllers;

import app.entities.Customer;
import app.entities.Instrument;
import app.services.implementations.CustomerService;
import app.services.implementations.InstrumentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Instrument")
public class InstrumentController {
    public final InstrumentService service;

    public InstrumentController(InstrumentService instrumentService){
        this.service = instrumentService;
    }

    @GetMapping("/All")
    public Iterable<Instrument> getAllInstrument(){
        return service.getAllInstruments();
    }

    @GetMapping("/{id}")
    public Instrument getInstrument(@PathVariable int id){
        return service.getInstrument(id);
    }

    @PostMapping("/Add")
    public void addInstrument(@RequestBody Instrument instrument){
        service.addInstrument(instrument);
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteInstrument(@PathVariable int id){
        service.deleteInstrument(id);
    }

    @PostMapping("/UpdateName/{id}")
    public void updateInstrumentName(@PathVariable int id, @RequestBody String name){
        service.updateInstrumentName(id, name);
    }

    @PostMapping("/UpdateDescription/{id}")
    public void updateInstrumentDescription(@PathVariable int id, @RequestBody String description){
        service.updateInstrumentDescription(id, description);
    }


}
