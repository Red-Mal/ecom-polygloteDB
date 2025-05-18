package com.example.ecompolyglotdb.model.mongo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "products")
public class Product {
    
    @Id
    private String id;
    
    private String name;
    
    private String description;
    
    private BigDecimal price;
    
    private Integer stockQuantity;
    
    private List<String> categories;
    
    private List<String> images;
    
    @Field("specifications")
    private List<Specification> specifications;
    
    @Field("created_at")
    private LocalDateTime createdAt;
    
    @Field("updated_at")
    private LocalDateTime updatedAt;
    
    @Data
    public static class Specification {
        private String name;
        private String value;
        
        public Specification() {}
        
        public Specification(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }
} 