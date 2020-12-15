package app.services.implementations;

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
        return reviewRepository.getOne(id);
    }

    @Override
    @Transactional
    public void updateReviewRating(int id, float newRating) {
        Review review = reviewRepository.getOne(id);
        review.setReviewRating(newRating);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void updateReviewPluses(int id, String newPluses) {
        Review review = reviewRepository.getOne(id);
        review.setReviewPluses(newPluses);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void updateReviewMinuses(int id, String newMinuses) {
        Review review = reviewRepository.getOne(id);
        review.setReviewMinuses(newMinuses);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void updateReviewOverview(int id, String newOverview) {
        Review review = reviewRepository.getOne(id);
        review.setReviewOverview(newOverview);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void deleteReview(int id) {
        reviewRepository.deleteById(id);
    }
}
