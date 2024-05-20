package com.TurkcellSRS.ProductService.DTO.Response;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.Set;

@Data
public class CategoryWithProductsResponse {
    private String name;
    private String description;

    @JsonManagedReference
    private Set<ProductResponse> product;
}
