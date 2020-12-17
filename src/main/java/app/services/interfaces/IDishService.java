package app.services.interfaces;

import app.entities.*;

public interface IDishService {
    void addDish(Dish dish);
    Iterable<Dish> getAllDishes();
    Iterable<Dish> getAllDishesCountries();
    Dish getDish(int id);
    void updateDishName(int id, String newName);
    void updateDishRecipe(int id, String newRecipe);
    void updateCountry(int id, Country country);
    void updateChef(int id, Chef chef);
    void addProduct(int id, Product product);
    void addInstrument(int id, Instrument instrument);
    void deleteDish(int id);

}
