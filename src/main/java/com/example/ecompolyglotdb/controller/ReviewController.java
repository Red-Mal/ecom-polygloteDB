package com.example.ecompolyglotdb.controller;

import com.example.ecompolyglotdb.dto.ReviewDTO;
import com.example.ecompolyglotdb.model.mongo.Review;
import com.example.ecompolyglotdb.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ReviewDTO>> getProductReviews(@PathVariable String productId) {
        return ResponseEntity.ok(reviewService.getProductReviews(productId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReviewDTO>> getUserReviews(@PathVariable Long userId) {
        return ResponseEntity.ok(reviewService.getUserReviews(userId));
    }

    @PostMapping("/product/{productId}/user/{userId}")
    public ResponseEntity<ReviewDTO> createReview(
            @PathVariable String productId,
            @PathVariable Long userId,
            @Valid @RequestBody Review review) {
        return ResponseEntity.ok(reviewService.createReview(review, productId, userId));
    }

    @DeleteMapping("/{reviewId}/user/{userId}")
    public ResponseEntity<Void> deleteReview(
            @PathVariable String reviewId,
            @PathVariable Long userId) {
        reviewService.deleteReview(reviewId, userId);
        return ResponseEntity.ok().build();
    }
} 