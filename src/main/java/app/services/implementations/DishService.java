package app.services.implementations;

import app.entities.Dish;
import app.reposes.DishRepository;
import app.services.interfaces.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DishService implements IDishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishService (DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }


    @Override
    @Transactional
    public void addDish(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    @Transactional
    public Iterable<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    @Transactional
    public Dish getDish(int id) {
        return dishRepository.getOne(id);
    }

    @Override
    @Transactional
    public void updateDishName(int id, String newName) {
        Dish dish = dishRepository.getOne(id);
        dish.setDishName(newName);
        dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void updateDishRecipe(int id, String newRecipe) {
        Dish dish = dishRepository.getOne(id);
        dish.setDishRecipe(newRecipe);
        dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void deleteDish(int id) {
        dishRepository.deleteById(id);
    }
}
