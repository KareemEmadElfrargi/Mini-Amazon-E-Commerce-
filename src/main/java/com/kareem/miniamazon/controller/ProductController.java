package com.kareem.miniamazon.controller;

import com.kareem.miniamazon.dto.ApiResponse;
import com.kareem.miniamazon.dto.ProductDTO;
import com.kareem.miniamazon.dto.ProductRequest;
import com.kareem.miniamazon.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<ApiResponse<Page<ProductDTO>>> getAllProducts(Pageable pageable){
        return ResponseEntity.ok(
                ApiResponse.<Page<ProductDTO>>builder()
                        .success(true)
                        .message("Products retrieved successfully")
                        .data(productService.getAllProducts(pageable))
                        .build()
        );
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.<ProductDTO>builder()
                        .success(true)
                        .message("Product retrieved successfully")
                        .data(productService.getProductById(id))
                        .build()
        );
    }

    @PostMapping("/admin/products")
    public ResponseEntity<ApiResponse<ProductDTO>> createProduct(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(
                ApiResponse.<ProductDTO>builder()
                        .success(true)
                        .message("Product created successfully")
                        .data(productService.createProduct(request))
                        .build()
        );
    }
    @PutMapping("/admin/products/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequest request
    ) {
        return ResponseEntity.ok(
                ApiResponse.<ProductDTO>builder()
                        .success(true)
                        .message("Product updated successfully")
                        .data(productService.updateProduct(id, request))
                        .build()
        );
    }

    @DeleteMapping("/admin/products/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .success(true)
                        .message("Product deleted successfully")
                        .build()
        );
    }

}
