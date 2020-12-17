package app.services.implementations;

import app.entities.*;
import app.reposes.DishRepository;
import app.services.interfaces.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

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
    public Iterable<Dish> getAllDishesCountries() {
        return dishRepository.getAllCountries();
    }

    @Override
    @Transactional
    public Dish getDish(int id) {
        return dishRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateDishName(int id, String newName) {
        Dish dish = dishRepository.findById(id).get();
        dish.setDishName(newName);
        dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void updateDishRecipe(int id, String newRecipe) {
        Dish dish = dishRepository.findById(id).get();
        dish.setDishRecipe(newRecipe);
        dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void updateCountry(int id, Country country) {
        Dish dish = dishRepository.findById(id).get();
        dish.setCountry(country);
        dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void updateChef(int id, Chef chef) {
        Dish dish = dishRepository.findById(id).get();
        dish.setChef(chef);
        dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void addProduct(int id, Product product) {
        Dish dish = dishRepository.findById(id).get();
        dish.getProducts().add(product);
        dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void addInstrument(int id, Instrument instrument) {
        Dish dish = dishRepository.findById(id).get();
        dish.getInstruments().add(instrument);
        dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void deleteDish(int id) {
        dishRepository.deleteById(id);
    }
}
