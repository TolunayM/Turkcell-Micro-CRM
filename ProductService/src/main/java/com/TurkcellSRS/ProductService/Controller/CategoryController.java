package com.TurkcellSRS.ProductService.Controller;


import com.TurkcellSRS.ProductService.DTO.Response.CategoryResponse;
import com.TurkcellSRS.ProductService.DTO.Response.CategoryWithProductsResponse;
import com.TurkcellSRS.ProductService.Logic.Contract.CategoryService;
import com.TurkcellSRS.ProductService.Logic.Services.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/{id}")
    public ResponseEntity<CategoryWithProductsResponse> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
