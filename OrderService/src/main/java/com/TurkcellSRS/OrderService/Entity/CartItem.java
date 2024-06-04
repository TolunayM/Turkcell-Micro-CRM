package com.TurkcellSRS.OrderService.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CartItem {

    @Id
    private Long id;
    private String name;
    private Integer quantity;
    private Double price;
}
