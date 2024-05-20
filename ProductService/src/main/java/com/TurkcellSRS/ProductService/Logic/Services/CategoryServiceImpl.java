package com.TurkcellSRS.ProductService.Logic.Services;


import com.TurkcellSRS.ProductService.DTO.Response.CategoryResponse;
import com.TurkcellSRS.ProductService.DTO.Response.CategoryWithProductsResponse;
import com.TurkcellSRS.ProductService.Logic.Contract.CategoryService;
import com.TurkcellSRS.ProductService.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    @Override
    public ResponseEntity<CategoryWithProductsResponse> getCategoryById(Long id) {
        var category = categoryRepository.findById(id);
        return ResponseEntity.ok(modelMapper.map(category, CategoryWithProductsResponse.class));
    }

    @Override
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        var categories = categoryRepository.findAll();
        return ResponseEntity.ok(Collections.singletonList(modelMapper.map(categories, CategoryResponse.class)));
    }




}
