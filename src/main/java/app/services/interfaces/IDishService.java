package app.services.interfaces;

import app.entities.Dish;

public interface IDishService {
    void addDish(Dish dish);
    Iterable<Dish> getAllDishes();
    Dish getDish(int id);
    void updateDishName(int id, String newName);
    void updateDishRecipe(int id, String newRecipe);
    void deleteDish(int id);
}
