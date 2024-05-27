package com.TurkcellSRS.ProductService.DTO.Request;


import lombok.Data;

import java.util.Map;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private Double price;
    private Map<String,Long> characteristics;
}
