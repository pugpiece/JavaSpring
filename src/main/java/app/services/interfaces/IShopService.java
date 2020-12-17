package app.services.interfaces;

import app.entities.Instrument;
import app.entities.Product;
import app.entities.Shop;

public interface IShopService {
    void addShop(Shop shop);
    Iterable<Shop> getAllShops();
    Shop getShop(int id);
    void updateShopName(int id, String newName);
    void updateShopDescription(int id, String newDescription);
    void deleteShop(int id);
    void addProduct(int id, Product product);
    void addInstrument(int id, Instrument instrument);
}
