package com.TurkcellSRS.OrderService.Client;


import com.TurkcellSRS.OrderService.DTO.BillingAccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service")
public interface BillingAccountClient {


    @GetMapping("/api/v1/accounts/{id}")
    BillingAccountDTO getBillingAccount(@PathVariable Long id);
}
