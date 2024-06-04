package com.TurkcellSRS.OrderService.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Entity
@Data
public class Cart {

    @Id
    private Long id;
    private Long customerId;
    private Double totalPrice;


//    //For saving only price and product will come from product service
//    @ElementCollection
//    private Map<Long,Double> products;
    @OneToMany
    private Set<CartItem> cartItems;
}
