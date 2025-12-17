package com.kareem.miniamazon.controller;

import com.kareem.miniamazon.dto.ApiResponse;
import com.kareem.miniamazon.dto.CategoryRequest;
import com.kareem.miniamazon.entity.Category;
import com.kareem.miniamazon.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<List<Category>>> getAllCategories() {
        return ResponseEntity.ok(
                ApiResponse.<List<Category>>builder()
                        .success(true)
                        .message("Categories retrieved successfully")
                        .data(categoryService.getAllCategories())
                        .build()
        );
    }

    @PostMapping("/admin/categories")
    public ResponseEntity<ApiResponse<Category>> createCategory(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok(
                ApiResponse.<Category>builder()
                        .success(true)
                        .message("Category created successfully")
                        .data(categoryService.createCategory(request))
                        .build()
        );
    }
}
