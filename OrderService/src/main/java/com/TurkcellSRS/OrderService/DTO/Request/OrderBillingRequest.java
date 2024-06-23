package com.TurkcellSRS.OrderService.DTO.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderBillingRequest {
    private Long billingAccountId;
    private String status;
}
