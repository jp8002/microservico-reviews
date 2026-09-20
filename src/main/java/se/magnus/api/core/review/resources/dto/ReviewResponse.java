package se.magnus.api.core.review.resources.dto;

public record ReviewResponse (
        Integer productId,
        Integer reviewId,
        String author,
        String subject,
        String content,
        String serviceAddress
) {}
