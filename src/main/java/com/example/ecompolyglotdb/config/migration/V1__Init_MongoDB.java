package com.example.ecompolyglotdb.config.migration;

import com.example.ecompolyglotdb.model.mongo.Product;
import com.example.ecompolyglotdb.model.mongo.Review;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class V1__Init_MongoDB extends BaseJavaMigration {

    private final MongoTemplate mongoTemplate;

    public V1__Init_MongoDB(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void migrate(Context context) {
        // Create products
        Product product1 = createProduct(
            "Premium Coffee Maker",
            "Professional-grade coffee maker with temperature control",
            new BigDecimal("199.99"),
            50,
            Arrays.asList("Appliances", "Kitchen"),
            Arrays.asList("coffee-maker-1.jpg", "coffee-maker-2.jpg"),
            Arrays.asList(
                new Product.Specification("Capacity", "12 cups"),
                new Product.Specification("Color", "Stainless Steel")
            )
        );

        Product product2 = createProduct(
            "Smart Watch Pro",
            "Advanced fitness tracking and notifications",
            new BigDecimal("299.99"),
            100,
            Arrays.asList("Electronics", "Wearables"),
            Arrays.asList("smartwatch-1.jpg", "smartwatch-2.jpg"),
            Arrays.asList(
                new Product.Specification("Battery Life", "5 days"),
                new Product.Specification("Water Resistance", "50m")
            )
        );

        Product product3 = createProduct(
            "Ergonomic Office Chair",
            "Comfortable chair with lumbar support",
            new BigDecimal("249.99"),
            30,
            Arrays.asList("Furniture", "Office"),
            Arrays.asList("chair-1.jpg", "chair-2.jpg"),
            Arrays.asList(
                new Product.Specification("Weight Capacity", "300 lbs"),
                new Product.Specification("Material", "Mesh")
            )
        );

        // Save products
        product1 = mongoTemplate.save(product1);
        product2 = mongoTemplate.save(product2);
        product3 = mongoTemplate.save(product3);

        // Create and save reviews
        List<Review> reviews = Arrays.asList(
            createReview(product1.getId(), 1L, 5, "Excellent Coffee Maker",
                "Makes perfect coffee every time. Temperature control is amazing!"),
            createReview(product2.getId(), 2L, 4, "Great Features",
                "Love the fitness tracking, battery life could be better"),
            createReview(product3.getId(), 1L, 5, "Very Comfortable",
                "Best office chair I've ever used. Great lumbar support!")
        );

        reviews.forEach(mongoTemplate::save);
    }

    private Product createProduct(String name, String description, BigDecimal price,
                                Integer stockQuantity, List<String> categories,
                                List<String> images, List<Product.Specification> specifications) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        product.setCategories(categories);
        product.setImages(images);
        product.setSpecifications(specifications);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return product;
    }

    private Review createReview(String productId, Long userId, Integer rating,
                              String title, String comment) {
        Review review = new Review();
        review.setProductId(productId);
        review.setUserId(userId);
        review.setRating(rating);
        review.setTitle(title);
        review.setComment(comment);
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());
        return review;
    }
} 