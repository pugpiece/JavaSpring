package app.services.implementations;

import app.entities.Instrument;
import app.reposes.InstrumentRepository;
import app.services.interfaces.IInstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InstrumentService implements IInstrumentService {

    private final InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentService(InstrumentRepository instrumentRepository){
        this.instrumentRepository = instrumentRepository;
    }


    @Override
    @Transactional
    public void addInstrument(Instrument instrument) {
        instrumentRepository.save(instrument);
    }

    @Override
    @Transactional
    public Iterable<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    @Override
    @Transactional
    public Instrument getInstrument(int id) {
        return instrumentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateInstrumentName(int id, String newName) {
        Instrument instrument = instrumentRepository.findById(id).get();
        instrument.setInstrumentName(newName);
        instrumentRepository.save(instrument);
    }

    @Override
    @Transactional
    public void updateInstrumentDescription(int id, String newDescription) {
        Instrument instrument = instrumentRepository.findById(id).get();
        instrument.setInstrumentDescription(newDescription);
        instrumentRepository.save(instrument);
    }

    @Override
    @Transactional
    public void deleteInstrument(int id) {
        instrumentRepository.deleteById(id);
    }
}
