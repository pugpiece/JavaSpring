package app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(
        name = "SHOP"
)
public class Shop {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int shopId;

    @Column(
            name = "SHOP_NAME",
            length = 50
    )
    private String shopName;

    @Column(
            name = "SHOP_DESCRIPTION",
            length = 10000
    )
    private String shopDescription;

    @Column(
            name = "RATING",
            length = 5
    )
    private float shopRating;

    @ManyToMany
    @JoinTable(
            name = "PRODUCT_TO_SHOP",
            joinColumns = {@JoinColumn(
                    name = "ID_SHOP"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "ID_PRODUCT"
            )}
    )
    @JsonManagedReference(value="PRODUCT_TO_SHOP")
    private Set<Product> products;

    @ManyToMany
    @JoinTable(
            name = "INSTRUMENT_TO_SHOP",
            joinColumns = {@JoinColumn(
                    name = "ID_SHOP"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "ID_INSTRUMENT"
            )}
    )
    @JsonManagedReference(value="INSTRUMENT_TO_SHOP")
    private Set<Instrument> instruments;

    public Shop() {
    }

    public int getShopId() { return this.shopId; }
    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() { return this.shopName; }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopDescription () { return this.shopDescription; }
    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public float getShopRating() {
        return this.shopRating;
    }
    public void setShopRating(float shopRating) {
        this.shopRating = shopRating;
    }

    public Set<Product> getProducts() { return this.products; }
    public void setProducts(Set<Product> products) { this.products = products; }

    public Set<Instrument> getInstruments() { return this.instruments; }
    public void setInstruments(Set<Instrument> instruments) { this.instruments = instruments; }
}
