package com.TurkcellSRS.PricingService.DTO;


import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CartProductsDTO {
    private List<ProductDTO> products;
}
