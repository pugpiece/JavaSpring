package app.services.interfaces;

import app.entities.Country;

public interface ICountryService {
    void addCountry(Country country);
    Iterable<Country> getAllCountries();
    Country getCountry(int id);
    void updateCountryName(int id, String newName);
    void deleteCountry(int id);
}
