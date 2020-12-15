package app.services.interfaces;

import app.entities.Product;

public interface IProductService {
    void addProduct(Product product);
    Iterable<Product> getAllProducts();
    Product getProduct(int id);
    void updateProductName(int id, String newName);
    void updateProductFats(int id, float newFats);
    void updateProductProteins(int id, float newProteins);
    void updateProductCarbohydrates(int id, float newCarbohydrates);
    void updateProductCalories(int id, float newCalories);
    void updateProductCost(int id, float newCost);
    void deleteProduct(int id);
}
