package app.services.interfaces;

import app.entities.Chef;

public interface IChefService {
    void addChef(Chef chef);
    Iterable<Chef> getAllChefs();
    Chef getChef(int id);
    void updateChefName(int id, String newName);
    void deleteChef(int id);
}
