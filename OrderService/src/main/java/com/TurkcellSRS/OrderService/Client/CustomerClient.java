package com.TurkcellSRS.OrderService.Client;


import com.TurkcellSRS.OrderService.DTO.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerClient {
    @GetMapping("api/v1/customers/{id}")
    CustomerDTO getCustomer(@PathVariable Long id);
}
