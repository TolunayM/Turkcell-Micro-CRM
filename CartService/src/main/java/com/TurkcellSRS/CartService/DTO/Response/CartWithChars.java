package com.TurkcellSRS.CartService.DTO.Response;


import lombok.Data;

import java.util.Map;

@Data
public class CartWithChars {
    private Map<Long,Integer> productId;
    private Map<String,Long> characteristics;
}
