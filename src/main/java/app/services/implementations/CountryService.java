package app.services.implementations;

import app.entities.Country;
import app.reposes.CountryRepository;
import app.services.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CountryService implements ICountryService{
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    @Transactional
    public Iterable<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    @Transactional
    public Country getCountry(int id) {
        return countryRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateCountryName(int id, String newName) {
        Country country = countryRepository.findById(id).get();
        country.setCountryName(newName);
        countryRepository.save(country);
    }

    @Override
    @Transactional
    public void deleteCountry(int id) {
        countryRepository.deleteById(id);
    }
}
