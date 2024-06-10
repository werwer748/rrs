package com.hugo.review.api;

import com.hugo.review.api.request.CreateReviewRequest;
import com.hugo.review.service.ReviewService;
import com.hugo.review.service.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewApi {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public void createReview(
            @RequestBody CreateReviewRequest request
    ) {
        reviewService.createReview(request.getRestaurantId(), request.getContent(), request.getScore());
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
    }

    @GetMapping("/restaurant/{restaurantId}/reviews")
    public ReviewDto getRestaurantReviews(
            @PathVariable Long restaurantId,
            @RequestParam("offset") Integer offset,
            @RequestParam("limit") Integer limit
    ) {
        return reviewService.getRestaurantReview(restaurantId, PageRequest.of(offset / limit, limit));
    }
}
