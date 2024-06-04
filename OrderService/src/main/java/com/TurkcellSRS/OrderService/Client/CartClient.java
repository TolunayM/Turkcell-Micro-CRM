package com.TurkcellSRS.OrderService.Client;


import com.TurkcellSRS.OrderService.DTO.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cart-service")
public interface CartClient {

    @GetMapping("/api/v1/cart/customer/{customerId}")
    CartDTO getCartByCustomerId(@PathVariable Long customerId);
}
