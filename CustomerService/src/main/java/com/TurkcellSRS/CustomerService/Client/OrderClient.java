package com.TurkcellSRS.CustomerService.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service")
public interface OrderClient {

    @GetMapping("/api/v1/orders/checkOrder/{customerId}")
    boolean checkOrderByCustomerId(@PathVariable Long customerId);
}
