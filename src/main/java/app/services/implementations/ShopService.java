package app.services.implementations;

import app.entities.Shop;
import app.reposes.ShopRepository;
import app.services.interfaces.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ShopService implements IShopService {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopService (ShopRepository shopRepository){
        this.shopRepository = shopRepository;
    }


    @Override
    @Transactional
    public void addShop(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    @Transactional
    public Iterable<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    @Transactional
    public Shop getShop(int id) {
        return shopRepository.getOne(id);
    }

    @Override
    @Transactional
    public void updateShopName(int id, String newName) {
        Shop shop = shopRepository.getOne(id);
        shop.setShopName(newName);
        shopRepository.save(shop);
    }

    @Override
    @Transactional
    public void updateShopDescription(int id, String newDescription) {
        Shop shop = shopRepository.getOne(id);
        shop.setShopDescription(newDescription);
        shopRepository.save(shop);
    }

    @Override
    @Transactional
    public void deleteShop(int id) {
        shopRepository.deleteById(id);
    }
}
