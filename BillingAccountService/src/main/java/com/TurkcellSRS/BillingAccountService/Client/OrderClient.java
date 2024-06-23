package com.TurkcellSRS.BillingAccountService.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service")
public interface OrderClient {

    @GetMapping("/api/v1/orders/checkOrder/b/{billingAccountId}")
    boolean checkOrderByBillingAccountId(@PathVariable Long billingAccountId);
}
