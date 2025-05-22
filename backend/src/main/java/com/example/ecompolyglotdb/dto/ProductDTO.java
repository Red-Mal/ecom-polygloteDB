package com.example.ecompolyglotdb.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String category;
    private String imageUrl;
    private Double averageRating;
    private Integer reviewCount;
} 