package se.magnus.api.core.review.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.magnus.api.core.review.domain.entities.ReviewEntity;
import se.magnus.api.core.review.domain.repositories.ReviewRepository;
import se.magnus.api.core.review.resources.dto.ReviewResponse;
import se.magnus.api.core.review.utils.http.ServiceUtil;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ServiceUtil util;

    public List<ReviewResponse> getByProductId(int productId) {
        return reviewRepository.findByProductId(productId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    private ReviewResponse toDto(ReviewEntity entity) {
        return ReviewResponse.builder()
                .reviewId(entity.getReviewId())
                .productId(entity.getProductId())
                .author(entity.getAuthor())
                .subject(entity.getSubject())
                .content(entity.getContent())
                .serviceAddress(util.getServerAddress())
                .build();
    }
}
