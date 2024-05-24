package com.TurkcellSRS.ProductService.DTO.Response;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;


import java.util.Set;

@Data
public class ProductResponseWithCategory {
    private Long id;
    private String name;
    private String description;
    private Double price;

    @JsonManagedReference
    private Set<CategoryResponse> category;


}
