package com.example.ecompolyglotdb.service;

import com.example.ecompolyglotdb.dto.ReviewDTO;
import com.example.ecompolyglotdb.exception.ResourceNotFoundException;
import com.example.ecompolyglotdb.model.mongo.Product;
import com.example.ecompolyglotdb.model.mongo.Review;
import com.example.ecompolyglotdb.model.postgres.User;
import com.example.ecompolyglotdb.repository.mongo.ProductRepository;
import com.example.ecompolyglotdb.repository.mongo.ReviewRepository;
import com.example.ecompolyglotdb.repository.postgres.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public List<ReviewDTO> getProductReviews(String productId) {
        return reviewRepository.findByProductId(productId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<ReviewDTO> getUserReviews(Long userId) {
        return reviewRepository.findByUserId(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ReviewDTO createReview(Review review, String productId, Long userId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        review.setProductId(productId);
        review.setUserId(userId);
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());

        Review savedReview = reviewRepository.save(review);
        return convertToDTO(savedReview);
    }

    @Transactional
    public void deleteReview(String reviewId, Long userId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review", "id", reviewId));

        if (!review.getUserId().equals(userId)) {
            throw new IllegalStateException("User not authorized to delete this review");
        }

        reviewRepository.delete(review);
    }

    private ReviewDTO convertToDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setProductId(review.getProductId());
        dto.setUserId(review.getUserId());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setTitle(review.getTitle());
        dto.setCreatedAt(review.getCreatedAt());

        // Fetch additional information
        productRepository.findById(review.getProductId())
                .ifPresent(product -> dto.setProductName(product.getName()));
        
        userRepository.findById(review.getUserId())
                .ifPresent(user -> dto.setUserName(user.getName()));

        return dto;
    }
} 