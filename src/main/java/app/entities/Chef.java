package app.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "CHEF")
public class Chef extends Customer{

    @Column(
            name = "RATING",
            length = 5
    )
    private float chefRating;

    @JsonBackReference(value="DISH_TO_CHEF")
    @OneToMany(mappedBy = "chef", fetch=FetchType.EAGER)
    private Set<Dish> dishes;

    public Chef() {
    }

    public Chef(String login, String password) {
        super(login,password);
        chefRating = 0;
    }

    public float getChefRating() { return this.chefRating; }
    public void setChefRating(float chefRating) {
        this.chefRating = chefRating;
    }

    public Set<Dish> getDishes() {return this.dishes;}
    public void setDishes(Set<Dish> dishes) {this.dishes = dishes;}
}
