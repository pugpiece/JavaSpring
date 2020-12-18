package app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(
        name = "DISH"
)
public class Dish {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int dishId;

    @Column(
            name = "DISH_NAME",
            length = 50
    )
    private String dishName;

    @Column(
            name = "RECIPE",
            length = 10000
    )
    private String dishRecipe;

    @ManyToOne(
            targetEntity = Country.class,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "countryId"
    )
    @JsonManagedReference(value="DISH_TO_COUNTRY")
    private Country country;

    @ManyToOne(
            targetEntity = Chef.class,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "customerId"
    )
    @JsonManagedReference(value="DISH_TO_CHEF")
    private Chef chef;

    @ManyToMany
    @JoinTable(
            name = "PRODUCT_TO_DISH",
            joinColumns = {@JoinColumn(
                    name = "ID_DISH"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "ID_PRODUCT"
            )}
    )
    @JsonManagedReference(value="PRODUCT_TO_DISH")
    private Set<Product> products;

    @ManyToMany
    @JoinTable(
            name = "INSTRUMENT_TO_DISH",
            joinColumns = {@JoinColumn(
                    name = "ID_DISH"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "ID_INSTRUMENT"
            )}
    )
    @JsonManagedReference(value="INSTRUMENT_TO_DISH")
    private Set<Instrument> instruments;

    @JsonBackReference(value="REVIEW_TO_DISH")
    @OneToMany(mappedBy = "dish", fetch=FetchType.EAGER)
    private Set<Review> reviews;

    public Dish() {
    }

    public int getDishId() { return this.dishId; }
    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() { return this.dishName; }
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishRecipe () { return this.dishRecipe; }
    public void setDishRecipe(String dishRecipe) {
        this.dishRecipe = dishRecipe;
    }

    public Country getCountry() { return this.country; }
    public void setCountry(Country country) {
        this.country = country;
    }

    public Chef getChef() { return this.chef; }
    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public Set<Product> getProducts() { return this.products; }
    public void setProducts(Set<Product> products) { this.products = products; }

    public Set<Instrument> getInstruments() { return this.instruments; }
    public void setInstruments(Set<Instrument> instruments) { this.instruments = instruments; }

    public Set<Review> getReviews() {return this.reviews;}
    public void setReviews(Set<Review> reviews) {this.reviews = reviews;}

}
