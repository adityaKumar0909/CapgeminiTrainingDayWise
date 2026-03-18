package com.ak.udemyLite.controller;

import com.ak.udemyLite.entity.Review;
import com.ak.udemyLite.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public Review getReviewById(@RequestParam long id){
        return reviewService.findById(id);
    }

    @PostMapping
    public void addReview(@RequestBody Review review){
        reviewService.addReview(review);
    }
    @DeleteMapping
    public void deleteReviewById(@RequestParam long id){
        reviewService.deleteReviewById(id);
    }






}
