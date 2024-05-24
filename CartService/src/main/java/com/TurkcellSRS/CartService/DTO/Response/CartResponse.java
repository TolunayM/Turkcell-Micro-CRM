package com.TurkcellSRS.CartService.DTO.Response;


import lombok.Data;

import java.util.Map;

@Data
public class CartResponse {

    private Long id;
    private Long customerId;
    private Map<Long,Integer> productId;
    private Double totalPrice;

}
