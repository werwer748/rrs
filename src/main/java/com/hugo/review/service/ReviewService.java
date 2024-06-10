package com.hugo.review.service;

import com.hugo.review.model.ReviewEntity;
import com.hugo.review.repository.RestaurantRepository;
import com.hugo.review.repository.ReviewRepository;
import com.hugo.review.service.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void createReview(
            Long restaurantId,
            String content,
            Double score
    ) {
        restaurantRepository.findById(restaurantId).orElseThrow(); // 없는 레스토랑이면 에러

        ReviewEntity review = ReviewEntity.builder()
                .restaurantId(restaurantId)
                .content(content)
                .score(score)
                .createdAt(ZonedDateTime.now())
                .build();

        reviewRepository.save(review);
    }

    @Transactional
    public void deleteReview(Long reviewId) {
        ReviewEntity review = reviewRepository.findById(reviewId).orElseThrow();
        reviewRepository.delete(review);
    }

    public ReviewDto getRestaurantReview(Long restaurantId, Pageable pageable) {
        Double avgScore = reviewRepository.getAvgScoreByRestaurantId(restaurantId);
        Slice<ReviewEntity> reviews = reviewRepository.findSliceByRestaurantId(restaurantId, pageable);

        return ReviewDto.builder()
                .avgScore(avgScore)
                .reviews(reviews.getContent())
                .page(
                        ReviewDto.ReviewDtoPage.builder()
                                .offset(pageable.getPageNumber() * pageable.getPageSize())
                                .limit(pageable.getPageSize())
                                .build()
                )
                .build();
    }
}
