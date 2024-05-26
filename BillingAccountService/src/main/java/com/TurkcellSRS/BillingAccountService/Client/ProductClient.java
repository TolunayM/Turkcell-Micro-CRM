package com.TurkcellSRS.BillingAccountService.Client;

import com.TurkcellSRS.BillingAccountService.DTO.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/api/v1/product/{productId}")
    ProductDTO getProductById(Long productId);
}
