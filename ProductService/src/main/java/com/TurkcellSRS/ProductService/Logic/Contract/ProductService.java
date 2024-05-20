package com.TurkcellSRS.ProductService.Logic.Contract;


import com.TurkcellSRS.ProductService.DTO.Response.ProductResponse;
import com.TurkcellSRS.ProductService.DTO.Response.ProductResponseWithCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<ProductResponseWithCategory> getProductById(Long id);
    ResponseEntity<List<ProductResponse>> getAllProducts();
}
