package app.controllers;

import app.entities.Instrument;
import app.entities.Review;
import app.services.implementations.InstrumentService;
import app.services.implementations.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    public final ReviewService service;

    public ReviewController(ReviewService reviewService){
        this.service = reviewService;
    }

    @GetMapping("/Reviews")
    public Iterable<Review> getAllReviews(){
        return service.getAllReviews();
    }

    @GetMapping("/Review/{id}")
    public Review getReview(@PathVariable int id){
        return service.getReview(id);
    }

    @GetMapping("/addReview")
    public void addReview(@RequestBody Review review){
        service.addReview(review);
    }

    @GetMapping("/deleteReview/{id}")
    public void deleteReview(@PathVariable int id){
        service.deleteReview(id);
    }

    @GetMapping("/updateReviewRating/{id}")
    public void updateReviewRating(@PathVariable int id, @RequestBody float rating){
        service.updateReviewRating(id, rating);
    }

    @GetMapping("/updateReviewPluses/{id}")
    public void updateReviewPluses(@PathVariable int id, @RequestBody String pluses){
        service.updateReviewPluses(id, pluses);
    }

    @GetMapping("/updateReviewMinuses/{id}")
    public void updateReviewMinuses(@PathVariable int id, @RequestBody String minuses){
        service.updateReviewMinuses(id, minuses);
    }

    @GetMapping("/updateReviewOverview/{id}")
    public void updateReviewOverview(@PathVariable int id, @RequestBody String overview){
        service.updateReviewOverview(id, overview);
    }




}
