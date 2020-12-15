package app.services.interfaces;

import app.entities.Instrument;

public interface IInstrumentService {
    void addInstrument(Instrument instrument);
    Iterable<Instrument> getAllInstruments();
    Instrument getInstrument(int id);
    void updateInstrumentName(int id, String newName);
    void updateInstrumentDescription(int id, String newDescription);
    void deleteInstrument(int id);
}
