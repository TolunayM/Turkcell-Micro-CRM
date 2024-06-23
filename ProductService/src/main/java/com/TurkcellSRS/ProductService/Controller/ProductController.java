package com.TurkcellSRS.ProductService.Controller;

import com.TurkcellSRS.ProductService.DTO.Request.ProductRequest;
import com.TurkcellSRS.ProductService.DTO.Response.ProductResponse;
import com.TurkcellSRS.ProductService.DTO.Response.ProductResponseWithCategory;
import com.TurkcellSRS.ProductService.Logic.Contract.ProductService;
import com.TurkcellSRS.ProductService.Logic.Services.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getAllProductsByCategory(categoryId);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> searchProductByVariables(@RequestParam(required = false, defaultValue = " ") Long categoryId,
                                                                          @RequestParam(required = false, defaultValue = " ") String name,
                                                                          @RequestParam(required = false, defaultValue = " ") Long id){
        return productService.searchByVariables(categoryId,id, name);
    }

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

    @GetMapping("/price/{productId}")
public ResponseEntity<Double> getProductPrice(@PathVariable Long productId){
        return productService.getProductPrice(productId);
    }
}
