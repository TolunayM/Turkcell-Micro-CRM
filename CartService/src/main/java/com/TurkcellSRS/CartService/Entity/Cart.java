package com.TurkcellSRS.CartService.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Double totalPrice;
//    @ManyToMany
//    @JoinTable(
//            name = "cart_cart_item",
//            joinColumns = @JoinColumn(name = "cart_id"),
//            inverseJoinColumns = @JoinColumn(name = "cart_item_id")
//    )
//    private List<CartItem> cartItems;

    @ElementCollection
    private Map<Long,Integer> productId;
}