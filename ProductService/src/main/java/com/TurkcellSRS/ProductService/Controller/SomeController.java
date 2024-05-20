package com.TurkcellSRS.ProductService.Controller;

import com.TurkcellSRS.ProductService.DTO.Response.ProductResponseWithCategory;
import com.TurkcellSRS.ProductService.Logic.Services.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/some")
@RequiredArgsConstructor
public class SomeController {

    private final ProductServiceImpl productService;

    @GetMapping("/data")
    public String getSome() {
        return "This is some data from ProductService.";
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<ProductResponseWithCategory> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
