package app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(
        name = "PRODUCT"
)
public class Product {

   @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int productId;

    @Column(
            name = "PRODUCT_NAME",
            length = 50
    )
    private String productName;

    @Column(
            name = "FATS_PER_GRAMM",
            length = 1000
    )
    private float productFats;

    @Column(
            name = "PROTEINS_PER_GRAMM",
            length = 1000
    )
    private float productProteins;

    @Column(
            name = "CARBOHYDRATES_PER_GRAMM",
            length = 1000
    )
    private float productCarbohydrates;

    @Column(
            name = "CALORIES_PER_GRAMM",
            length = 1000
    )
    private float productCalories;

    @Column(
            name = "COST",
            length = 1000
    )
    private float productCost;

    @ManyToMany
    @JoinTable(
            name = "PRODUCT_TO_DISH",
            joinColumns = {@JoinColumn(
                    name = "ID_PRODUCT"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "ID_DISH"
            )}
    )
    @JsonBackReference(value="PRODUCT_TO_DISH")
    private Set<Dish> dishes;

    @ManyToMany
    @JoinTable(
            name = "PRODUCT_TO_SHOP",
            joinColumns = {@JoinColumn(
                    name = "ID_PRODUCT"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "ID_SHOP"
            )}
    )
    @JsonBackReference(value="PRODUCT_TO_SHOP")
    private Set<Shop> shops;

    public Product() {
    }

    public int getProductId() {
        return this.productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductFats() {
        return this.productFats;
    }
    public void setProductFats(float productFats) {
        this.productFats = productFats;
    }

    public float getProductProteins() {
        return this.productProteins;
    }
    public void setProductProteins(float productProteins) {
        this.productProteins = productProteins;
    }

    public float getProductCarbohydrates() {
        return this.productCarbohydrates;
    }
    public void setProductCarbohydrates(float productCarbohydrates) {
        this.productCarbohydrates = productCarbohydrates;
    }

    public float getProductCalories() {
        return this.productCalories;
    }
    public void setProductCalories(float productCalories) {
        this.productCalories = productCalories;
    }

    public float getProductCost() {
        return this.productCost;
    }
    public void setProductCost(float productCost) {
        this.productCost = productCost;
    }

    public Set<Dish> getDishes() {
        return this.dishes;
    }
    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public Set<Shop> getShops() {
        return this.shops;
    }
    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

}
