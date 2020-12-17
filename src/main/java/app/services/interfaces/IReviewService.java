package app.services.interfaces;

import app.entities.Customer;
import app.entities.Dish;
import app.entities.Review;

public interface IReviewService {
    void addReview(Review review);
    Iterable<Review> getAllReviews();
    Review getReview(int id);
    void updateReviewRating(int id, float newRating);
    void updateReviewPluses(int id, String newPluses);
    void updateReviewMinuses(int id, String  newMinuses);
    void updateReviewOverview(int id, String newOverview);
    void deleteReview(int id);
    void updateReviewDish(int id, Dish dish);
    void updateReviewCustomer(int id, Customer customer);
}
