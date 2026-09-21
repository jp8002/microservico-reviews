package se.magnus.api.core.review.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {
    private int reviewId;
    private int productId;
    private String author;
    private String subject;
    private String content;
    private String serviceAddress;
}
