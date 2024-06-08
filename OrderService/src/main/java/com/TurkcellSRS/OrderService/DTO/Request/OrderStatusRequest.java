package com.TurkcellSRS.OrderService.DTO.Request;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderStatusRequest {
    private Long customerId;
    private String status;
}
