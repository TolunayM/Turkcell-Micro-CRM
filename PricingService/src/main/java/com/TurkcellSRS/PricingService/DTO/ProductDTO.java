package com.TurkcellSRS.PricingService.DTO;

import lombok.Data;

import java.util.Map;

@Data
public class ProductDTO {

    private Long id;
    private Double price;
    private Map<String,Long> characteristics;
}
