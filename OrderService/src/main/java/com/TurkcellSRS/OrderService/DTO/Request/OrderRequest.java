package com.TurkcellSRS.OrderService.DTO.Request;


import lombok.Data;

@Data
public class OrderRequest {
    private Long customerId;
    private Long billingAccountId;
}
