package app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity
@Table(
        name = "REVIEW"
)
public class Review {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int reviewId;

    @Column(
            name = "RATING",
            length = 5
    )
    private float reviewRating;

    @Column(
            name = "PLUSES",
            length = 50
    )
    private String reviewPluses;

    @Column(
            name = "MINUSES",
            length = 50
    )
    private String reviewMinuses;

    @Column(
            name = "OVERVIEW",
            length = 50
    )
    private String reviewOverview;

    @ManyToOne(
            targetEntity = Customer.class,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "ID_CUSTOMER"
    )
    @JsonManagedReference(value="REVIEW_TO_CUSTOMER")
    private Customer customer;

    @ManyToOne(
            targetEntity = Dish.class,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "ID_DISH"
    )
    @JsonManagedReference(value="REVIEW_TO_DISH")
    private Dish dish;

    public Review() {
    }

    public int getReviewId() { return this.reviewId; }
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public float getReviewRating() { return this.reviewRating; }
    public void setReviewRating(float reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getReviewPluses() { return this.reviewPluses; }
    public void setReviewPluses(String reviewPluses) {
        this.reviewPluses = reviewPluses;
    }

    public String getReviewMinuses() { return this.reviewMinuses; }
    public void setReviewMinuses(String reviewMinuses) {
        this.reviewMinuses = reviewMinuses;
    }

    public String getReviewOverview() { return this.reviewOverview; }
    public void setReviewOverview(String reviewOverview) {
        this.reviewOverview = reviewOverview;
    }

    public Customer getCustomer() { return this.customer; }
    public void setCustomer(Customer reviewOverview) {
        this.customer = customer;
    }

    public Dish getDish() { return this.dish; }
    public void setDish(Dish dish) {
        this.dish = dish;
    }


}
