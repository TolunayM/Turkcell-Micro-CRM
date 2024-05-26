package com.TurkcellSRS.CartService.DTO.Response;


import lombok.Data;

import java.util.Map;

@Data
public class CartProductsResponse {
    private Map<Long,Integer> productId;
}
