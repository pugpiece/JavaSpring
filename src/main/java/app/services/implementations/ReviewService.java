package app.services.implementations;

import app.entities.Customer;
import app.entities.Dish;
import app.entities.Review;
import app.reposes.ReviewRepository;
import app.services.interfaces.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReviewService implements IReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    @Transactional
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public Iterable<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    @Transactional
    public Review getReview(int id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateReviewRating(int id, float newRating) {
        Review review = reviewRepository.findById(id).get();
        review.setReviewRating(newRating);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void updateReviewPluses(int id, String newPluses) {
        Review review = reviewRepository.findById(id).get();
        review.setReviewPluses(newPluses);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void updateReviewMinuses(int id, String newMinuses) {
        Review review = reviewRepository.findById(id).get();
        review.setReviewMinuses(newMinuses);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void updateReviewOverview(int id, String newOverview) {
        Review review = reviewRepository.findById(id).get();
        review.setReviewOverview(newOverview);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void deleteReview(int id) {
        reviewRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateReviewDish(int id, Dish dish) {
        Review review = reviewRepository.findById(id).get();
        review.setDish(dish);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void updateReviewCustomer(int id, Customer customer) {
        Review review = reviewRepository.findById(id).get();
        review.setCustomer(customer);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void deleteAllNoUser() {
        Iterable<Review> reviews = reviewRepository.findAll();
        for(Review review : reviews) {
            if (review.getCustomer() == null)
                reviewRepository.deleteById(review.getReviewId());
            else
                reviewRepository.save(review);
        }
    }
}
