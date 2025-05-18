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
    private Integer stockQuantity;
    private List<String> categories;
    private List<String> images;
    private Double averageRating;
    private Integer reviewCount;
} 