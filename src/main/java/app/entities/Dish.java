package app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(
        name = "Dish"
)
public class Dish {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int dishId;

    @Column(
            name = "dishName",
            length = 50
    )
    private String dishName;

    @Column(
            name = "dishRecipe",
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
    @JsonBackReference(value="dishToCountry")
    private Country country;

    @ManyToOne(
            targetEntity = Chef.class,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "customerId"
    )
    @JsonBackReference(value="dishToChef")
    private Chef chef;

    @ManyToMany
    @JoinTable(
            name = "ProductToDish",
            joinColumns = {@JoinColumn(
                    name = "dishId"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "productId"
            )}
    )
    @JsonIgnore
    private Set<Product> products;

    @ManyToMany
    @JoinTable(
            name = "InstrumentToDish",
            joinColumns = {@JoinColumn(
                    name = "dishId"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "instrumentId"
            )}
    )
    @JsonIgnore
    private Set<Instrument> instruments;

    @JsonManagedReference(value="reviewToDish")
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
