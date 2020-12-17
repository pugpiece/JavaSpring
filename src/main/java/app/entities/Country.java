package app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(
        name = "Country"
)
public class Country {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int countryId;

    @Column(
            name = "countryName",
            length = 50
    )
    private String countryName;

    @Column(
            name = "countryDescription",
            length = 10000
    )
    private String countryDescription;

    @JsonManagedReference(value="dishToCountry")
    @OneToMany(mappedBy = "country", fetch=FetchType.EAGER)
    private Set<Dish> dishes;

    public Country() {
    }

    public int getCountryId() { return this.countryId; }
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() { return this.countryName; }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryDescription () { return this.countryDescription; }
    public void setCountryDescription(String countryDescription) {
        this.countryDescription = countryDescription;
    }

    public Set<Dish> getDishes() {return this.dishes;}
    public void setDishes(Set<Dish> dishes) {this.dishes = dishes;}
}
