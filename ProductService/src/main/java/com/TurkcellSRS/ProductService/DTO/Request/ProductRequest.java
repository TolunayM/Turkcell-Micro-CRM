package com.TurkcellSRS.ProductService.DTO.Request;


import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private Double price;
}
