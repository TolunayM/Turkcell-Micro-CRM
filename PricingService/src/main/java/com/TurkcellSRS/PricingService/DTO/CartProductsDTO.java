package com.TurkcellSRS.PricingService.DTO;


import lombok.Data;

import java.util.Map;

@Data
public class CartProductsDTO {
    private Map<Long,Integer> productId;
}
