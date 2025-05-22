package com.example.ecompolyglotdb.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReviewDTO {
    private String id;
    private String productId;
    private String productName;
    private Long userId;
    private String userName;
    private Integer rating;
    private String comment;
    private String title;
    private LocalDateTime createdAt;
} 