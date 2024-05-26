package com.TurkcellSRS.ProductService.Logic.Services;

import com.TurkcellSRS.ProductService.DTO.Request.ProductRequest;
import com.TurkcellSRS.ProductService.DTO.Response.ProductResponse;
import com.TurkcellSRS.ProductService.DTO.Response.ProductResponseWithCategory;
import com.TurkcellSRS.ProductService.Entity.Category;
import com.TurkcellSRS.ProductService.Entity.Product;
import com.TurkcellSRS.ProductService.Logic.Contract.ProductService;
import com.TurkcellSRS.ProductService.Repository.CategoryRepository;
import com.TurkcellSRS.ProductService.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public ResponseEntity<ProductResponseWithCategory> getProductById(Long id) {
        return ResponseEntity.ok(modelMapper.map(productRepository.findById(id), ProductResponseWithCategory.class));
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productRepository
                .findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductResponse.class)).toList());
    }

    public ResponseEntity<ProductResponse> createProduct(ProductRequest productRequest) {
        var product = modelMapper.map(productRequest, Product.class);
        var savedProduct = productRepository.save(product);
        return ResponseEntity.ok(modelMapper.map(savedProduct,ProductResponse.class));
    }

    public ResponseEntity<ProductResponse> assignCategory(Long productId, Long categoryId){

        //TODO MAPPER AND CHECK INFINITE LOOP
        var product = productRepository.findById(productId);
        var category = categoryRepository.findById(categoryId);
        if (product.isPresent() && category.isPresent()) {
            product.get().getCategory().add(category.get());
            category.get().getProduct().add(product.get());
            productRepository.save(product.get());
            categoryRepository.save(category.get());
            return ResponseEntity.ok(modelMapper.map(product.get(), ProductResponse.class));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Double> getProductPrice(Long productId){
        var product = productRepository.findById(productId);
        if(product.isPresent()){
            return ResponseEntity.ok(product.get().getPrice());
        }
        return ResponseEntity.notFound().build();
    }
}
