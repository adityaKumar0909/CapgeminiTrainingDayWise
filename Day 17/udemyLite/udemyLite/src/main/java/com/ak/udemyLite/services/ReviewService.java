package com.ak.udemyLite.services;


import com.ak.udemyLite.entity.Review;
import com.ak.udemyLite.repository.ReviewRepo;
import org.springframework.stereotype.Component;

@Component
public class ReviewService {

    ReviewRepo reviewRepo;

    ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    public Review findById(Long id) {
        return reviewRepo.findById(id).orElse(null);
    }

    public void addReview (Review review) {
        reviewRepo.save(review);
    }

    public void deleteReviewById(Long id) {
        reviewRepo.deleteById(id);
    }


}
