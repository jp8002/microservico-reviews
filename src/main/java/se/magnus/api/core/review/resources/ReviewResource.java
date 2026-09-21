package se.magnus.api.core.review.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import se.magnus.api.core.review.domain.entities.ReviewEntity;
import se.magnus.api.core.review.domain.repositories.ReviewRepository;
import se.magnus.api.core.review.resources.dto.ReviewResponse;
import se.magnus.api.core.review.services.ReviewService;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewResource {
    private final ReviewRepository repository;
    private final ReviewService service;

    @GetMapping
    public ResponseEntity<List<ReviewResponse>> getReviews(@RequestParam Integer productId){
        if (productId < 1) {
            return ResponseEntity.unprocessableContent().build();
        }
        List<ReviewResponse> reviews = service.getByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createReview(@RequestBody ReviewEntity review){
        ReviewEntity saved = repository.save(review);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{reviewId}")
                .buildAndExpand(saved.getReviewId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping
    public void deleteReviews(@RequestParam int productId){
        repository.deleteByProductId(productId);
    }
}
