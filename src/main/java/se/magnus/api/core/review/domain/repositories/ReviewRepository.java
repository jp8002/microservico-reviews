package se.magnus.api.core.review.domain.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.magnus.api.core.review.domain.entities.ReviewEntity;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
    List<ReviewEntity> findByProductId(int productId);
    @Transactional
    void deleteByProductId(int id);
}
