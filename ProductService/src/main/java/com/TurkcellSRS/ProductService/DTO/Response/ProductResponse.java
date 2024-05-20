package com.TurkcellSRS.ProductService.DTO.Response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ProductResponse {
    private String name;
    private String description;
    private Double price;

    @JsonBackReference
    private Set<CategoryResponse> category;
}
