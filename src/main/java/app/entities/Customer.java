package app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(
        name = "CUSTOMER"
)
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int customerId;

    @Column(
            name = "CUSTOMER_LOGIN",
            length = 50
    )
    private String customerLogin;

    @Column(
            name = "CUSTOMER_PASSWORD",
            length = 50
    )
    private int customerPassword;

    @JsonBackReference(value="REVIEW_TO_CUSTOMER")
    @OneToMany(mappedBy = "customer", fetch=FetchType.EAGER)
    private Set<Review> reviews;



    public Customer() {
    }

    public Customer(String login, String password) {
        customerLogin = login;
        customerPassword = password.hashCode();

    }

    public int getCustomerId() { return this.customerId; }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerLogin() { return this.customerLogin; }
    public void setCustomerLogin(String customerLogin) {
        this.customerLogin = customerLogin;
    }

    public int getCustomerPassword() { return this.customerPassword; }
    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword.hashCode();
    }

    public Set<Review> getReviews() {return this.reviews;}
    public void setReviews(Set<Review> reviews) {this.reviews = reviews;}

}
