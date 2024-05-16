package com.TurkcellSRS.CustomerService.Product;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ProductService", url = "http://localhost:8083")
public interface ProductClient {

    @GetMapping("/some/data")
    public String getSome();
}
