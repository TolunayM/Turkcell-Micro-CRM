package com.TurkcellSRS.ProductService.DTO.Response;

import lombok.Data;

import java.util.List;

@Data
public class CategoryResponse {
    private String name;
    private String description;
    //private List<ProductResponse> product;
}
