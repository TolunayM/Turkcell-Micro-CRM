package com.TurkcellSRS.ProductService.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchProductResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
}
