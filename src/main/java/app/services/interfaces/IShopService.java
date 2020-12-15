package app.services.interfaces;

import app.entities.Shop;

public interface IShopService {
    void addShop(Shop shop);
    Iterable<Shop> getAllShops();
    Shop getShop(int id);
    void updateShopName(int id, String newName);
    void updateShopDescription(int id, String newDescription);
    void deleteShop(int id);
}
