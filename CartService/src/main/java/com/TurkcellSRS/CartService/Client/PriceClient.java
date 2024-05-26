package com.TurkcellSRS.CartService.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "price-service")
public interface PriceClient {

    @GetMapping("/api/v1/price/{cartId}")
    Double calculatePrice(@PathVariable Long cartId);
}
