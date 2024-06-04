package com.TurkcellSRS.OrderService.Client;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "product-service")
public interface ProductClient {
}
