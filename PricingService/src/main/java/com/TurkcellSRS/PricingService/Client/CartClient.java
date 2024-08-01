package com.TurkcellSRS.PricingService.Client;


import com.TurkcellSRS.PricingService.DTO.CartProductsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cart-service")
public interface CartClient {

    @GetMapping("/api/v1/cart/items/{cartId}")
    CartProductsDTO getCartProducts(@PathVariable Long cartId);
}
