package com.TurkcellSRS.ProductService.Logic.Services;

import com.TurkcellSRS.ProductService.DTO.Response.ProductResponse;
import com.TurkcellSRS.ProductService.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ResponseEntity<ProductResponse> getProductById(Long id) {
        return ResponseEntity.ok(modelMapper.map(productRepository.findById(id), ProductResponse.class));
    }
}
