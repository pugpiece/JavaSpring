package app.controllers;

import app.entities.Customer;
import app.entities.Dish;
import app.entities.Instrument;
import app.entities.Review;
import app.services.implementations.InstrumentService;
import app.services.implementations.ReviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Review")
public class ReviewController {
    public final ReviewService service;

    public ReviewController(ReviewService reviewService){
        this.service = reviewService;
    }

    @GetMapping("/All")
    public Iterable<Review> getAllReviews(){
        return service.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReview(@PathVariable int id){
        return service.getReview(id);
    }

    @PostMapping("/Add")
    public void addReview(@RequestBody Review review){
        service.addReview(review);
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteReview(@PathVariable int id){
        service.deleteReview(id);
    }

    @PostMapping("/UpdateRating/{id}")
    public void updateReviewRating(@PathVariable int id, @RequestBody float rating){
        service.updateReviewRating(id, rating);
    }

    @PostMapping("/UpdatePluses/{id}")
    public void updateReviewPluses(@PathVariable int id, @RequestBody String pluses){
        service.updateReviewPluses(id, pluses);
    }

    @PostMapping("/UpdateMinuses/{id}")
    public void updateReviewMinuses(@PathVariable int id, @RequestBody String minuses){
        service.updateReviewMinuses(id, minuses);
    }

    @PostMapping("/UpdateOverview/{id}")
    public void updateReviewOverview(@PathVariable int id, @RequestBody String overview){
        service.updateReviewOverview(id, overview);
    }

    @PostMapping("/UpdateDish/{id}")
    public void updateReviewDish(@PathVariable int id, @RequestBody Dish dish){
        service.updateReviewDish(id, dish);
    }

    @PostMapping("/UpdateCustomer/{id}")
    public void updateReviewCustomer(@PathVariable int id, @RequestBody Customer customer){
        service.updateReviewCustomer(id, customer);
    }




}
