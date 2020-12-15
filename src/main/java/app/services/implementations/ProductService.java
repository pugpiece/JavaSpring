package app.services.implementations;

import app.entities.Product;
import app.reposes.ProductRepository;
import app.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    @Transactional
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product getProduct(int id) {
        return productRepository.getOne(id);
    }

    @Override
    @Transactional
    public void updateProductName(int id, String newName) {
        Product product = productRepository.getOne(id);
        product.setProductName(newName);
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProductFats(int id, float newFats) {
        Product product = productRepository.getOne(id);
        product.setProductFats(newFats);
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProductProteins(int id, float newProteins) {
        Product product = productRepository.getOne(id);
        product.setProductProteins(newProteins);
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProductCarbohydrates(int id, float newCarbohydrates) {
        Product product = productRepository.getOne(id);
        product.setProductCarbohydrates(newCarbohydrates);
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProductCalories(int id, float newCalories) {
        Product product = productRepository.getOne(id);
        product.setProductCalories(newCalories);
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProductCost(int id, float newCost) {
        Product product = productRepository.getOne(id);
        product.setProductCost(newCost);
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
