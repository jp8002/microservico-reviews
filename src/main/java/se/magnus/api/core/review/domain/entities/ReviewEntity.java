package se.magnus.api.core.review.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity (name = "reviews")
public class ReviewEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(nullable = false)
    private int productId;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String content;

}
