package com.TurkcellSRS.CartService.Entity;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Map;

@Data
@Entity
public class CartItem {

    @Id
    private Long id;
    private Integer quantity;
    @ElementCollection
    private Map<String,Integer> characteristics;
}
