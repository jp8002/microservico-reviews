package se.magnus.api.core.review.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import se.magnus.api.core.review.domain.repositories.ReviewRepository;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewResource {
    private final ReviewRepository repository;

    @DeleteMapping
    public void deleteReviews(@RequestParam int productId){
        repository.deleteByProductId(productId);
    }
}
