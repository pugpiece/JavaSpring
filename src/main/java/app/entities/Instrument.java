package app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(
        name = "INSTRUMENT"
)
public class Instrument {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int instrumentId;

    @Column(
            name = "INSTRUMENT_NAME",
            length = 50
    )
    private String instrumentName;

    @Column(
            name = "INSTRUMENT_DESCRIPTION",
            length = 10000
    )
    private String instrumentDescription;

    @Column(
            name = "PRICE",
            length = 100000
    )
    private float instrumentCost;

    @ManyToMany
    @JoinTable(
            name = "INSTRUMENT_TO_DISH",
            joinColumns = {@JoinColumn(
                    name = "instrumentId"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "dishId"
            )}
    )
    @JsonIgnore
    private Set<Dish> dishes;

    @ManyToMany
    @JoinTable(
            name = "INSTRUMENT_TO_SHOP",
            joinColumns = {@JoinColumn(
                    name = "instrumentId"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "shopId"
            )}
    )
    @JsonIgnore
    private Set<Shop> shops;

    public Instrument() {
    }

    public int getInstrumentId() {
        return this.instrumentId;
    }
    public void setInstrumentId(int instrumentId) { this.instrumentId = instrumentId; }

    public String getInstrumentName() {
        return this.instrumentName;
    }
    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getInstrumentDescription () { return this.instrumentDescription; }
    public void setInstrumentDescription(String instrumentDescription) { this.instrumentDescription = instrumentDescription; }

    public float getInstrumentCost() { return this.instrumentCost; }
    public void setInstrumentCost(float instrumentCost) {
        this.instrumentCost = instrumentCost;
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
