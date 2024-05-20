package com.TurkcellSRS.ProductService.Controller;

import com.TurkcellSRS.ProductService.DTO.Request.ProductRequest;
import com.TurkcellSRS.ProductService.DTO.Response.ProductResponse;
import com.TurkcellSRS.ProductService.DTO.Response.ProductResponseWithCategory;
import com.TurkcellSRS.ProductService.Logic.Services.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;


    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseWithCategory> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @PostMapping("/{productId}/category/{categoryId}")
    public ResponseEntity<ProductResponse> assignCategory(@PathVariable Long productId, @PathVariable Long categoryId){
        return productService.assignCategory(productId, categoryId);
    }
}
