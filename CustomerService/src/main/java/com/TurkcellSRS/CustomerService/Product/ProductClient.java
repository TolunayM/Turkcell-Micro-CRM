package com.TurkcellSRS.CustomerService.Product;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/some/data")
    String getSome();

    @GetMapping("/api/v1/products/{id}")
    ResponseEntity<?> getProductById(@PathVariable Long id);
}
