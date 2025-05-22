package com.example.ecompolyglotdb.repository.mongo;

import com.example.ecompolyglotdb.model.mongo.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByProductId(String productId);
    List<Review> findByUserId(Long userId);
    
    @Query("{'productId': ?0, 'rating': {$gte: ?1}}")
    List<Review> findByProductIdAndMinRating(String productId, Integer minRating);
} 