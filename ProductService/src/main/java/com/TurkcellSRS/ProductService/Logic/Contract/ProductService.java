package com.TurkcellSRS.ProductService.Logic.Contract;


import com.TurkcellSRS.ProductService.DTO.Request.ProductRequest;
import com.TurkcellSRS.ProductService.DTO.Response.ProductResponse;
import com.TurkcellSRS.ProductService.DTO.Response.ProductResponseWithCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<ProductResponseWithCategory> getProductById(Long id);
    ResponseEntity<List<ProductResponse>> getAllProducts();
    ResponseEntity<List<ProductResponse>> getAllProductsByCategory(Long categoryId);
    ResponseEntity<ProductResponse> createProduct(ProductRequest productRequest);
    ResponseEntity<ProductResponse> assignCategory(Long productId, Long categoryId);
    ResponseEntity<Double> getProductPrice(Long productId);
    ResponseEntity<List<ProductResponse>> searchByVariables(Long categoryId, Long id, String name);
}
