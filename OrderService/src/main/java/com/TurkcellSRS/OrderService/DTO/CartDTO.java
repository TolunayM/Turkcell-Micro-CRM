package com.TurkcellSRS.OrderService.DTO;


import lombok.Data;

import java.util.Map;

@Data
public class CartDTO {

    private Long id;
    private Long customerId;
    private Map<Long,Integer> productId;
    private Double totalPrice;
}
