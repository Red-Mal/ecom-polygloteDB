package com.example.ecompolyglotdb.controller;

import com.example.ecompolyglotdb.dto.ProductDTO;
import com.example.ecompolyglotdb.model.mongo.Product;
import com.example.ecompolyglotdb.repository.mongo.ProductRepository;
import com.example.ecompolyglotdb.repository.mongo.ReviewRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "Product", description = "Product management APIs")
public class ProductController {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    @Operation(summary = "Get all products", description = "Retrieves a list of all products with their ratings")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved products")
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(productDTOs);
    }

    @Operation(summary = "Get product by ID", description = "Retrieves a specific product by its ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the product")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(
            @Parameter(description = "ID of the product to retrieve") @PathVariable String id) {
        return productRepository.findById(id)
            .map(this::convertToDTO)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get products by category", description = "Retrieves all products in a specific category")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved products")
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(
            @Parameter(description = "Category name") @PathVariable String category) {
        List<Product> products = productRepository.findByCategories(category);
        List<ProductDTO> productDTOs = products.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(productDTOs);
    }

    @Operation(summary = "Create a new product", description = "Creates a new product in the catalog")
    @ApiResponse(responseCode = "200", description = "Successfully created the product")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.ok(convertToDTO(savedProduct));
    }

    @Operation(summary = "Update a product", description = "Updates an existing product by its ID")
    @ApiResponse(responseCode = "200", description = "Successfully updated the product")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(
            @Parameter(description = "ID of the product to update") @PathVariable String id,
            @RequestBody Product product) {
        return productRepository.findById(id)
            .map(existingProduct -> {
                product.setId(id);
                Product updatedProduct = productRepository.save(product);
                return ResponseEntity.ok(convertToDTO(updatedProduct));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a product", description = "Deletes a product by its ID")
    @ApiResponse(responseCode = "200", description = "Successfully deleted the product")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "ID of the product to delete") @PathVariable String id) {
        return productRepository.findById(id)
            .map(product -> {
                productRepository.delete(product);
                return ResponseEntity.ok().<Void>build();
            })
            .orElse(ResponseEntity.notFound().build());
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStockQuantity());
        
        // Set the first category if available
        if (product.getCategories() != null && !product.getCategories().isEmpty()) {
            dto.setCategory(product.getCategories().get(0));
        }
        
        // Set the first image URL if available
        if (product.getImages() != null && !product.getImages().isEmpty()) {
            dto.setImageUrl(product.getImages().get(0));
        } else {
            // Set a default placeholder image
            dto.setImageUrl("https://via.placeholder.com/400");
        }
        
        // Calculate average rating and review count
        var reviews = reviewRepository.findByProductId(product.getId());
        dto.setReviewCount(reviews.size());
        dto.setAverageRating(reviews.stream()
            .mapToDouble(review -> review.getRating())
            .average()
            .orElse(0.0));
        
        return dto;
    }
} 