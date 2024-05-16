package com.TurkcellSRS.ProductService.DTO.Response;

import lombok.Data;

@Data
public class ProductResponse {
    private String name;
    private String description;
    private Double price;
    private String category;
}
