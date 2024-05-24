package com.TurkcellSRS.CartService.Client;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private Double price;
}
