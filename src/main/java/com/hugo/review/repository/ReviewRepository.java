package com.hugo.review.repository;

import com.hugo.review.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>, ReviewRepositoryCustom {
}
