package com.example.ecompolyglotdb.model.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDateTime;

@Data
@Document(collection = "reviews")
public class Review {
    
    @Id
    private String id;
    
    @Field("product_id")
    private String productId;
    
    @Field("user_id")
    private Long userId;
    
    private Integer rating;
    
    private String comment;
    
    private String title;
    
    @Field("created_at")
    private LocalDateTime createdAt;
    
    @Field("updated_at")
    private LocalDateTime updatedAt;
} 