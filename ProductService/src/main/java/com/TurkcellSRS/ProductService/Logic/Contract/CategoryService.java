package com.TurkcellSRS.ProductService.Logic.Contract;

import com.TurkcellSRS.ProductService.DTO.Response.CategoryResponse;
import com.TurkcellSRS.ProductService.DTO.Response.CategoryWithProductsResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    ResponseEntity<CategoryWithProductsResponse> getCategoryById(Long id);
    ResponseEntity<List<CategoryResponse>> getAllCategories();
}
