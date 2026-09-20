package se.magnus.api.core.review.domain.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.magnus.api.core.review.domain.entities.ReviewEntity;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
    @Transactional
    void deleteByProductId(int id);
}
