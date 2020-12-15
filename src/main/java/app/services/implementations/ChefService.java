package app.services.implementations;

import app.entities.Chef;
import app.reposes.ChefRepository;
import app.services.interfaces.IChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChefService implements IChefService {
    private final ChefRepository chefRepository;

    @Autowired
    public ChefService(ChefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }

    @Override
    @Transactional
    public void addChef(Chef chef) {
        chefRepository.save(chef);
    }

    @Override
    @Transactional
    public Iterable<Chef> getAllChefs() {
        return chefRepository.findAll();
    }

    @Override
    @Transactional
    public Chef getChef(int id) {
        return chefRepository.getOne(id);
    }

    @Override
    @Transactional
    public void updateChefName(int id, String newName) {
        Chef chef = chefRepository.getOne(id);
        chef.setCustomerLogin(newName);
        chefRepository.save(chef);
    }

    @Override
    @Transactional
    public void deleteChef(int id) {
        chefRepository.deleteById(id);
    }
}
