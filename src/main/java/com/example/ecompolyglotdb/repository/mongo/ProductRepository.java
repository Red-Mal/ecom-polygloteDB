package com.example.ecompolyglotdb.repository.mongo;

import com.example.ecompolyglotdb.model.mongo.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCategories(String category);
    
    @Query("{'stockQuantity': {$gt: 0}}")
    List<Product> findAvailableProducts();
    
    List<Product> findByCategoriesInAndStockQuantityGreaterThan(List<String> categories, Integer minStock);
} 